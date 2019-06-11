/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ItemPedido;
import Models.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.mnpaiva
 */
public class ItemPedidoDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static boolean salvar(ItemPedido p) {
        boolean retorno = false;
        //
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO itempedido"
                    + "(idItemPedido, idProduto, idPedido, qtdItem, valor) VALUES(null,?,?,?,?)");
            comando.setInt(1, p.getIdProduto());
            comando.setInt(2, p.getIdPedido());
            comando.setInt(3, p.getQtdItem());
            comando.setDouble(4, p.getValorItem());
            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                retorno = false;
            }
        }
        return retorno;
    }


}
