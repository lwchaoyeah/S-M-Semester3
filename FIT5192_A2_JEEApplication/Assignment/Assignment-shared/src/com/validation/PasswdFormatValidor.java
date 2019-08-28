/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wenchao
 */
public class PasswdFormatValidor {
    
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String PASSWD_PATTERN="^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,20}$";
    
    public PasswdFormatValidor() {
        pattern = Pattern.compile(PASSWD_PATTERN);
    }
    
    public boolean isPasswdValid(String passwd){
        matcher = pattern.matcher(passwd);
        return matcher.matches();
    }
}
