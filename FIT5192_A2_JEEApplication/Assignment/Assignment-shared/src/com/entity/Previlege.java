/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.naming.ldap.ManageReferralControl;

/**
 * used for user's identity(manager,visitor,custormer, administrator)
 * @author Wenchao
 */
public enum Previlege {
    Administrator("Administrator",1),Management("Management",2),Customer("Customer",3),Vistor("Visitor",4);
    private String name;
    private int index;
    private Previlege(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String getName(int index) {  
        for (Previlege c : Previlege.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }
    
    public static Integer getValue(String name) {  
        for (Previlege c : Previlege.values()) {  
            if (c.getName().equals(name)) {  
                return c.index;  
            }  
        }  
        return null;  
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
    
}
