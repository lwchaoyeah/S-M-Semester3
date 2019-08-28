/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;


/**
 *
 * @author Wenchao
 */
public class PhoneFormatValidator {
    
    public PhoneFormatValidator(){}
    
    public static boolean isPhoneNumberValid(String phoneNumber, String countryCode) {
        System.out.println("isPhoneNumberValid: " + phoneNumber + "/" + countryCode);
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phoneNumber, countryCode);
            return phoneUtil.isValidNumber(numberProto);
        } catch (NumberParseException e) {
            System.err.println("isPhoneNumberValid NumberParseException was thrown: " + e.toString());
        }
        return false;
    }
//    public static  void main(String args[]){
//        String phoneNumber = "15507929723";
//        String countryCode = "CN";
//        System.out.println(isPhoneNumberValid(phoneNumber, countryCode));
//    }
}
