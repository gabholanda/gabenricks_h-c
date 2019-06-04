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
import java.sql.SQLException;

/**
 *
 * @author lucas.mnpaiva
 */
public class ItemPedidoDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static boolean salvar(ItemPedido p) {
        boolean retorno = false;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO ItemPedido"
                    + "(produtoiD, pedidoId, quantidade) VALUES(?,?,?)");
            comando.setInt(1, p.getProdutoId());
            comando.setInt(2, p.getPedidoId());
            comando.setInt(3, p.getQuantidade());
            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
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
    public static boolean atualizar(ItemPedido p) {
        boolean retorno = false;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement comando = conexao.prepareStatement("UPDATE ItemPedido"
                    +"(produtoiD=?, pedidoId=?, quantidade=?) WHERE ITEMPEDIDOID =?");
            comando.setInt(1, p.getProdutoId());
            comando.setInt(2, p.getPedidoId());
            comando.setInt(3, p.getQuantidade());
            comando.setInt(4, p.getItempedidoId());
            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
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
    public static boolean excluir(int ItempedidoId) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM itempedido WHERE itempedidoid= ?");

            comando.setInt(1, ItempedidoId);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
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

