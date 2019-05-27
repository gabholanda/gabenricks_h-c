/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author tavar
 */
public class ModuloConexao {
//Método responsavel por estabelecer a conexao com o banco de dados

    public static Connection conector() {
        java.sql.Connection conexao = null;
        // A linha abaixo "chama" o driver
        String driver = "com.mysql.jdbc.Driver";
        // Armazenando informações referente ao banco
        /*
        linha abaixo usada para conexão sem SSL(chave de segurança) "fazer uma aplicação futura
        String url="jdbc:mysql://pesqcont.dyndns.org:3306/pesqueira_advogados?useTimezone=true&serverTimezone=UTC&useSSL=false";
         
        */
        String url = "jdbc:mysql://pesqcont.dyndns.org:63306/gabenricks?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "PI";
        String password = "gabenricks";
        // Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);

            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }

    }

}
