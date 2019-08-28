/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ProductBean;
import bean.RedirectFunction;
import bean.UserBean;
import com.api.ProductBeanService;
import com.entity.Previlege;
import com.entity.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jason
 */
@Named(value = "productController")
@RequestScoped
public class ProductController {
    @EJB
    private ProductBeanService productBeanService;
    
    private List<Product> products;
    
    
    private Product productPage = new Product();
    
    /**
     * Creates a new instance of ProductController
     */
    public ProductController() {
         
    }
    @PostConstruct
    public void init(){
//        this.product = productBeanService.searchbyid(2);
        
    }
    /**
     * @return the product
     */
    public Product getProductFromPara() {
        int productid = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("productId"));
        
        return productBeanService.searchbyid(productid);
    }
    
     public void getProductFromPara1() {
        int productid = Integer.valueOf(FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("productId"));
        
        productPage = productBeanService.searchbyid(productid);
    }
    
    public String removeProduct(){
        productBeanService.delete(this.productPage.getProductId());
        return RedirectFunction.redirect("/product/productInfoList.xhtml");
    }
    
    public String createProduct(ProductBean productBean){
        if( productBean.getShortTitle() == null || productBean.getShortTitle().length() == 0){
            return "/product/productInfoList";
        }
        this.productPage = productPageBeantoProduct(productBean);
        int productid=productBeanService.add(this.productPage);
        return RedirectFunction.redirect("/product/productInfo.xhtml?productId="+String.valueOf(productid) );
    }
    
    public List<Product> listAllProduct(){
        return productBeanService.searchAll();
    }
    
    
    public String searchProductFromHomePage(ProductBean productBean,UserBean userBean){
        searchProduct(productBean,userBean);
        return "/index";
    }
    
    public String searchProductFromInfoList(ProductBean productBean){
        searchProduct(productBean,null);
        return "/product/productInfoList";
    }
    
    public String updateProduct(){
//        searchProduct(productBean);
//        ExternalContext fce = FacesContext.getCurrentInstance().getExternalContext();
        productBeanService.update(productPage);
//        return "/product/updateProduct.xhtml?productId="+Integer.toString(this.productPage.getProductId());
        return RedirectFunction.redirect("/product/productInfoList.xhtml");
    }
    
    private void searchProduct(ProductBean productBean,UserBean userBean){
        Map<String,Object> searchParameterMap = new HashMap<>();
        if (productBean.getCategory()!=null && productBean.getCategory().length() !=0){
            searchParameterMap.put("category", productBean.getCategory());
        }else if (productBean.getRating()!= null && productBean.getRating()> 0 ){
            searchParameterMap.put("rating", productBean.getRating());
        }else if(productBean.getAuthor() != null && productBean.getAuthor().length() != 0){
            searchParameterMap.put("author", productBean.getAuthor());
        }else if(productBean.getPublish_house()!= null && productBean.getPublish_house().length() != 0){
            searchParameterMap.put("publish_house", productBean.getPublish_house());
        }else if(productBean.getShortTitle()!= null && productBean.getShortTitle().length() != 0){
            searchParameterMap.put("shortTitle", productBean.getShortTitle());
        }else if(productBean.getPrice()!= null && productBean.getPrice()> 0){
            searchParameterMap.put("price", productBean.getPrice());
        }
        if (!searchParameterMap.isEmpty()){
            products = productBeanService.searchByMultiCategory(searchParameterMap);
            
        }else{
            if (userBean == null) {
                products = productBeanService.searchAll();
            }else{
                products = productBeanService.searchRecommendation(userBean.getUserID());
            }
                
            
        }
        
    }
   
    private Product productPageBeantoProduct(ProductBean productBean){
        Product product = new Product();
//        Author
        if (productBean.getAuthor() != null) {
            product.setAuthor(productBean.getAuthor());
        }else{
            product.setAuthor("");
        }
//        Category
        if (productBean.getCategory() != null) {
            product.setCategory(productBean.getCategory());
        }else{
            product.setCategory("");
        }
//        price
        if (productBean.getPrice() != null ) {
            if (productBean.getPrice() < 0){
                product.setPrice(0l);
            }else{
                product.setPrice(productBean.getPrice());
            }
        }else{
            product.setPrice(0l);
        }
//        publish_house
        if (productBean.getPublish_house() != null){
            product.setPublish_house(productBean.getPublish_house());
        }else{
            product.setPublish_house("");
        }
//        rating
        if (productBean.getRating() != null) {
            if (productBean.getRating() >10) {
                product.setRating(10L);
            }else if(productBean.getRating() < 0){
                product.setRating(0L);
            }else{
                product.setRating(productBean.getRating());
            }
        }else{
            product.setRating(5L);
        }
        
        if (productBean.getShortTitle() == null || productBean.getShortTitle().length() == 0 ) {
            product.setShortTitle("missing title");
        }else{
            product.setShortTitle(productBean.getShortTitle());
        }
        
        return product;
    }
    

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return the productForPage
     */
    public Product getProductPage() {
        return productPage;
    }

    /**
     * @param productForPage the productForPage to set
     */
    public void setProductForPage(Product productPage) {
        this.productPage = productPage;
    }
 
    
    /**
     * @aim add product to shopping cart
     * @author Wenchao
     */
    public String addToShoppingCart(UserBean userBean){
        if (userBean.getMembershipLevel().equals(Previlege.Vistor.getName())) {
            this.productPage = productBeanService.searchbyid(this.productPage.getProductId());
            return "";
        }
        boolean isContained = userBean.getMapProductToNumber().containsKey(String.valueOf(this.productPage.getProductId()));
        if(isContained){
            Integer productNumber = userBean.getMapProductToNumber().get(String.valueOf(this.productPage.getProductId()));
            userBean.getMapProductToNumber().replace(String.valueOf(this.productPage.getProductId()), userBean.getProductNumber()+productNumber);
        }else{
            // Product searchbyid(int)
            Product product = this.productBeanService.searchbyid(this.productPage.getProductId().intValue());
            userBean.getProducts().add(product);
            userBean.getMapProductToNumber().put(String.valueOf(this.productPage.getProductId()), userBean.getProductNumber());
        }
        return "/index";
    }
    
    
    public Long sumProductFee(UserBean userBean){
        Long fee = 0l;
        for(Product product: userBean.getProducts()){
            fee = fee + product.getPrice() * userBean.getMapProductToNumber().get(String.valueOf(product.getProductId()));
        }
        return fee;
    }
}
