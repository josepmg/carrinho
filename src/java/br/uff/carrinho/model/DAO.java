/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public interface DAO {
    
    void fechaConexao() throws SQLException;
    
    void cria(Object obj);
    
    Object busca(int id);
    
    void altera(Object obj);
    
    void deleta(Object obj);
}
