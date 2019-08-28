/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jason
 */


public class RecommendationMatrix implements Serializable{


    private Integer ReMatrixId;
    private Integer UserM ;
    private String  ISBN ;
    private Integer rating;

  
    /**
     * @return the UserM
     */
    public Integer getUserM() {
        return UserM;
    }

    /**
     * @param UserM the UserM to set
     */
    public void setUserM(Integer UserM) {
        this.UserM = UserM;
    }

  

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the ReMatrixId
     */
    public Integer getReMatrixId() {
        return ReMatrixId;
    }

    /**
     * @param ReMatrixId the ReMatrixId to set
     */
    public void setReMatrixId(Integer ReMatrixId) {
        this.ReMatrixId = ReMatrixId;
    }
}
