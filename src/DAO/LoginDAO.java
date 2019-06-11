/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Login;
import Views.PrincipalView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Patrick Chagas
 */
public class LoginDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String URL = "jdbc:mysql://locahost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
        private static Connection conexao;

    /**
     * String driver = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
        String url = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC"; //alterar para caminho do banco de dados
        String user = "root";
        String password = "adminadmin";
     */
    /**
     * Metodo para Consultar usuario
     */
    public static boolean Consultar(Login c) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
//"select login, CAST(AES_DECRYPT(senha,'SENAC') as char) from usuarios "
            //+ "where login = ? and senha = AES_ENCRYPT(?,'" + Chave_cryptografia + "')";
            PreparedStatement comando = conexao.prepareStatement("select login, CAST(AES_DECRYPT(senha,'SENAC') as char) from usuarios "
                    + "where login = ? and senha = AES_ENCRYPT(?, SENACPI2019)");

            comando.setString(1, c.getUsuario()); //Posição 1 = Usuario
            comando.setString(2, c.getSenha());
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                //direcionamento para tela principal, apos o usuario ser aprovado
                PrincipalView TelaPrincipal = new PrincipalView();
                TelaPrincipal.setVisible(true);

                retorno = true;
            } else {

                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }

        return retorno;

    }
}
