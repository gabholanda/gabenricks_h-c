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
public class StatusDAO {
//Método responsavel por estabelecer a conexao com o banco de dados

    public static Connection conector() {
        java.sql.Connection conexao = null;
        // A linha abaixo "chama" o driver
        //String driver = "com.mysql.jdbc.Driver";
        String driver = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
        String url = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC"; //alterar para caminho do banco de dados
        String user = "root";
        String password = "adminadmin";
        // Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);

            return conexao;
        } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ErroConexao) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o Banco de dados.\n\nFavor verificar sua conexão com a internet e tentar novamente.", "Problema de conexão", JOptionPane.ERROR_MESSAGE);
            return null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }

    }

}
