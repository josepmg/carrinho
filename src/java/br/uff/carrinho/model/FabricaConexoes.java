/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JP
 */
public class FabricaConexoes {
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/carrinho", "devweb", "0532" );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
