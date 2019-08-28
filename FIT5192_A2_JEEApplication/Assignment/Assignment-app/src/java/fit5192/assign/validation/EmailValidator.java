/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assign.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wenchao
 */
public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = 
//        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
           "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Validate hex with regular expression
     * 
     * @param email
     * 
     * @return true - valid email, false - invalid email
     */
    public boolean validate(final String email) {

        matcher = pattern.matcher(email);
        return matcher.matches();

    }
}

