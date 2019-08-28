/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

/**
 *
 * @author Wenchao
 */
public class NameValidator {
    public static boolean isAnyNumber(String str){
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                return true;
            } 
        }
        return false;
    }
}
