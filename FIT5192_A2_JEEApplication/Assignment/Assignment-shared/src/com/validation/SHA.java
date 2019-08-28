/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validation;

import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Wenchao
 */
public class SHA  
{  

  /** 
   * input String，return SHA-256 String 
   *  
   * @param strText 
   * @return 
   */  
  public static String SHA256(final String strText)  
  {  
    return SHA(strText, "SHA-256");  
  }  

  /** 
   * input String，return SHA-512 String
   *  
   * @param strText 
   * @return 
   */  
  public static String SHA512(final String strText)  
  {  
    return SHA(strText, "SHA-512");  
  }  

  /** 
   * String SHA Encryption 
   *  
   * @param strSourceText 
   * @return 
   */  
  private static String SHA(final String strText, final String strType)  
  {  
    // return value  
    String strResult = null;  

    // isValid  
    if (strText != null && strText.length() > 0)  
    {  
      try  
      {  
        // SHA Start Encryption  
        // select encryption type  
        MessageDigest messageDigest = MessageDigest.getInstance(strType);  
        // input source string  
        messageDigest.update(strText.getBytes());  
        // get byte typed result  
        byte byteBuffer[] = messageDigest.digest();  

        // convert byte into string  
        StringBuilder strHexString = new StringBuilder();  
        //  byte buffer  
        for (int i = 0; i < byteBuffer.length; i++)  
        {  
          String hex = Integer.toHexString(0xff & byteBuffer[i]);  
          if (hex.length() == 1)  
          {  
            strHexString.append('0');  
          }  
          strHexString.append(hex);  
        }  
        // return result  
        strResult = strHexString.toString();  
      }  
      catch (NoSuchAlgorithmException e)  
      {  
        e.printStackTrace();
      }  
    }  

    return strResult;  
  }  
}
