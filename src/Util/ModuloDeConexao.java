/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.*;
/**
 *
 * @author Geraldo
 */
public class ModuloDeConexao {
    /**
     * Método para conexão com o Banco de Dados
     */
    public static Connection conector(){
        //Objeto criado para verificar se há conexão
        java.sql.Connection conexao = null;
        //Linha responsável por chamar o driver
        String driver = "com.mysql.jdbc.Driver";
        //Linha responsável por armazenar url do banco
        //jdbc:mysql:// --> padrão do conector jdbc
        //endereço do banco com a porta padrão do mysql
        String url = "jdbc:mysql://localhost:3306/connect_church";
        //Identificadores do usuário do banco
        String user = "root";
        String password = "39030105";
        //Conectando ao banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
               
            return null;
        }
        
    }
}