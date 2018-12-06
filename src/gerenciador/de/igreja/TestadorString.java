/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.de.igreja;

/**
 *
 * @author Rafael
 */
public class TestadorString {
 
    public static String testeEmpty(String str){
        if (str == null || str.isEmpty()){
            return null;
        }
        else{
            return str;
        }
    }
    
}
