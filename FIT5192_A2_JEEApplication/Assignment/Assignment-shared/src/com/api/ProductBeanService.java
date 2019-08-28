/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import com.entity.Product;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.persistence.Query;

/**
 *
 * @author Jason
 */
@Remote
public interface ProductBeanService {
    int add(Product product);
    int delete(int id);
    int update(Product product);
    Product searchbyid(int id);
    List<Product> searchAll();
    List<Product> searchByAuthor(String s);
    List<Product> searchByPrice(long price);
    List<Product> searchByCategory(String s);
    List<Product> searchByTitle(String title);
    List<Product> searchByMultiCategory(Map<String,Object> conditions);
    List<Product> searchRecommendation(Integer userId);
}
