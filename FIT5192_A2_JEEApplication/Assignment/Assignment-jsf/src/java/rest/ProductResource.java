/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.api.ProductBeanService;
import com.entity.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * it's used for retrieve information or AJAX request
 * @author Jason
 */
@Path("product")
@RequestScoped
public class ProductResource {

    @EJB
    private ProductBeanService productBeanService;
    /**
     * Retrieves representation of an instance of rest.ProductResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product search(@PathParam("id") Integer id) {
        //TODO return proper representation object
        return productBeanService.searchbyid(id);
    }

    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Product entity) {
        productBeanService.add(entity);
    }
    
    
    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(Product entity) {
        productBeanService.update(entity);
    }


    @POST
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int delete( @PathParam("id") Integer id) {
        //TODO return proper representation object
        return productBeanService.delete(id);
    }
    
    @GET
    @Path("/search/author/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchByAuthor( @PathParam("author") String author) {
        //TODO return proper representation object
        return productBeanService.searchByAuthor(author);
    }
    @GET
    @Path("/search/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchByTitle( @PathParam("title") String title) {
        //TODO return proper representation object
        return productBeanService.searchByTitle(title);
    }
    @GET
    @Path("/search/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchByCategory( @PathParam("category") String category) {
        //TODO return proper representation object
        return productBeanService.searchByCategory(category);
    }
    
    @POST
    @Path("/multiSearch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> multiSearch( Product product ) {
        //TODO return proper representation object
        Map<String,Object> map = new HashMap<String, Object>();
        if ( null != product.getAuthor()){
            map.put("author", product.getAuthor());
        }
        if ( null != product.getPrice() ){
            map.put("price", product.getPrice());
        }
        if (null != product.getShortTitle()){
            map.put("shortTitle", product.getShortTitle());
        }
        if (null != product.getPublish_house()){
            map.put("publish_house", product.getPublish_house());
        }
        if (null != product.getCategory()){
            map.put("category", product.getCategory());
        }
        return productBeanService.searchByMultiCategory(map);
    }
}
