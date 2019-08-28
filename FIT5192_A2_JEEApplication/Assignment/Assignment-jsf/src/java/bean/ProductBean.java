/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jason
 */
@Named(value = "productBean")
@RequestScoped
public class ProductBean {
    private String shortTitle; //name
    private Long price;         //price
    private String author;
    private Long rating;
    private String category;
    private String publish_house;
    private String next_page;
    
    /**
     * @return the shortTitle
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * @param shortTitle the shortTitle to set
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * @return the price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the rating
     */
    public Long getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Long rating) {
        this.rating = rating;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the publish_house
     */
    public String getPublish_house() {
        return publish_house;
    }

    /**
     * @param publish_house the publish_house to set
     */
    public void setPublish_house(String publish_house) {
        this.publish_house = publish_house;
    }

    /**
     * @return the next_page
     */
    public String getNext_page() {
        return next_page;
    }

    /**
     * @param next_page the next_page to set
     */
    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }
}
