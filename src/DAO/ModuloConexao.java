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
        String url = "jdbc:mysql://pesqcont.dyndns.org:63306/gabenricks?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "PI";
        String password = "gabenricks";
        // Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);

            return conexao;
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ErroConexao) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco de dados.\n \n Favor verificar sua conexão com a internet e tentar novamente.","Problema de conexão",JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }
        

    }

}
