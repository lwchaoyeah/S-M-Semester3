/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.KNN;

import com.api.ProductBeanService;
import com.entity.Product;
import com.entity.RecommendationMatrix;
import com.entity.TransactionProduct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jason
 */
@Stateless
public class ProductBeanServiceImpl implements ProductBeanService{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public int add(Product product) {
        em.persist(product);
        return product.getProductId();
    }

    @Override
    public int delete(int id) {
        Product product = em.find(Product.class, id);
        if (product != null){
            em.remove(product);
        }
        return 0;
    }

    @Override
    public int update(Product product) {
        em.merge(product);
        return 0;
    }

    @Override
    public Product searchbyid(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> searchByAuthor(String s) {

        Query q=em.createNamedQuery(Product.Search_By_Author);
        q.setParameter("author", s);
        return SortByRatio( q.getResultList() );
    }

    @Override
    public List<Product> searchByPrice(long price) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Product.class);
        Root<Product> p = query.from(Product.class);
        Expression<Long> temp = p.get("price").as(Long.class);
        query.select(p).where(builder.lessThanOrEqualTo(temp, price));
        
        return SortByRatio( em.createQuery(query).getResultList() );
    }

    @Override
    public List<Product> searchByCategory(String s) {
        Query q=em.createNamedQuery(Product.Search_By_Category);
        q.setParameter("category", s);
        return SortByRatio( q.getResultList() );

    }

    @Override
    public List<Product> searchByTitle(String title) {
        Query q=em.createNamedQuery(Product.Search_By_Title);
        q.setParameter("shortTitle", title);
        return SortByRatio( q.getResultList() );
    }
    
    private List<Product> SortByRatio(List<Product> products){
        if (null == products){
            return Collections.EMPTY_LIST;
        }
        Collections.sort(products,new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                if( o1.getRating() == null || o2.getRating() == null){
                    return (int)(o2.getPrice() - o1.getPrice());
                }
                return (int) (o2.getRating()-o1.getRating());
            }
        });
        return products;
    }

    @Override
    public List<Product> searchByMultiCategory(Map<String, Object> conditions) {

        StringBuilder builder = new StringBuilder("SELECT p from Product p where ");
        for (Map.Entry<String,Object> entry: conditions.entrySet()){
            String s;
            if (entry.getKey().equals("price")){
                s = "p.price <= :"+(String)(entry.getKey())+" and ";
            }else if(entry.getKey().equals("rating")){
                s = "p.rating <= :"+(String)(entry.getKey())+" and ";
            } else{
                s = "p."+entry.getKey()+" = :"+entry.getKey()+" and ";
            }
            builder.append(s);
        }
        String jpql = builder.toString();//erase " and " 5 length
        jpql=jpql.substring(0, jpql.length() - 5);
//        System.out.print(jpql);
        Query q=em.createQuery(jpql, Product.class);
        for (Map.Entry<String,Object> entry: conditions.entrySet()){
            q.setParameter(entry.getKey(), entry.getValue());
        }
        return SortByRatio( q.getResultList() );
    }

    @Override
    public List<Product> searchAll() {
        Query q=em.createNamedQuery(Product.Search_all);
        return SortByRatio( q.getResultList() );
    }
    
    @Override
    public List<Product> searchRecommendation(Integer userId) {
        KNN.loadMatrix("./database_recommendations_user_rating.csv");
        List<RecommendationMatrix> recommendationMatrix = KNN.matrix;
        Query qTP=em.createNamedQuery(TransactionProduct.SEARCH_BY_USERID);
        qTP.setParameter("userId", userId);
        List<TransactionProduct> transactionProducts=qTP.getResultList();
        List<RecommendationMatrix> users_preference = new ArrayList<>();
        for(TransactionProduct tp : transactionProducts){
            if (tp.getProduct().getProductId() > 2000) {
                continue;
            }
            RecommendationMatrix recommendationMatrix_temp = new RecommendationMatrix();
            recommendationMatrix_temp.setUserM(userId);
            if (tp.getRating() == null) {
                recommendationMatrix_temp.setRating(5); //as default rating
            }else{
                recommendationMatrix_temp.setRating(tp.getRating());
            }
            recommendationMatrix_temp.setISBN(tp.getProduct().getISBN());
            users_preference.add(recommendationMatrix_temp);
        }
        List<String> ISBNS = KNN.applyKNN(recommendationMatrix,users_preference,10); //return top 10
        Query qbook=em.createNamedQuery(Product.Search_BY_ISBN);
        qbook.setParameter("ISBN", ISBNS);
        
        
        return qbook.getResultList() == null ?Collections.EMPTY_LIST: qbook.getResultList();
//        Query q=em.createNamedQuery(Product.Search_all);
//        return SortByRatio( q.getResultList() );
    }
    
}
