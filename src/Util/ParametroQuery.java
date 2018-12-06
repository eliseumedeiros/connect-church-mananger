/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Rafael
 */
public class ParametroQuery {
    private String nomeParametro;
    private Object valorParametro;
    private Object valorParametro2;
    private String operacao;

    public ParametroQuery() {
    }

    public ParametroQuery(String nomeParametro, Object valorParametro) {
        this.nomeParametro = nomeParametro;
        this.valorParametro = valorParametro;
    }

    public ParametroQuery(String nomeParametro, Object valorParametro, String operacao) {
        this.nomeParametro = nomeParametro;
        this.valorParametro = valorParametro;
        this.operacao = operacao;
    }

    public ParametroQuery(String nomeParametro, Object valorParametro, Object valorParametro2, String operacao) {
        this.nomeParametro = nomeParametro;
        this.valorParametro = valorParametro;
        this.valorParametro2 = valorParametro2;
        this.operacao = operacao;
    }
    
    public String getNomeParametro() {
        return nomeParametro;
    }

    public void setNomeParametro(String nomeParametro) {
        this.nomeParametro = nomeParametro;
    }

    public Object getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(Object valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Object getValorParametro2() {
        return valorParametro2;
    }

    public void setValorParametro2(Object valorParametro2) {
        this.valorParametro2 = valorParametro2;
    }
    
}
