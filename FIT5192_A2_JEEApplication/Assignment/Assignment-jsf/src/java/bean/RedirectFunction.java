/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jason
 */
public class RedirectFunction {
    public static String redirect(String relativePath){
        String absolutePath = "/Assignment-jsf/faces";
        String path = absolutePath+relativePath;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(path);
        } catch (IOException ex) {
            Logger.getLogger(RedirectFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return path;           
    }
}
