/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Rafael
 */
public enum Ordem {
    CRESCENTE,
    DECRESCENTE;
    
    public String getSqlOrder(){
        if (this.equals(Ordem.CRESCENTE)){
            return "ASC";
        }
        else{
            return "DESC";
        }
    }
}
