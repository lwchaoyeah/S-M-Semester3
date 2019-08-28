/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Jason
 */
public class NoNumberValidator implements ConstraintValidator<NoNumbers, String>{

    @Override
    public void initialize(NoNumbers constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        for(int i=0;i<value.length();i++){
            if (value.charAt(i) >= '0' && value.charAt(i) <= '9'){
                return false;
            } 
        }
        return true;
    }
    
}
