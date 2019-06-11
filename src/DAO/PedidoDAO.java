/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.ItemPedido;
import Models.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.paiva & Patrick Chagas
 */
public class PedidoDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static ArrayList<Pedido> consultaCliente(String dados, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> listaClientes = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement comando = null;
            ResultSet rs = null;

            //codição para consultar por nome ou CPF, com base no tipo indicado
            if (tipo == 1) {
                comando = conexao.prepareStatement("select idCliente, nome , CPF from cliente where nome like ?");
                comando.setString(1, dados + "%");
                rs = comando.executeQuery();
            } else if (tipo == 2) {
                comando = conexao.prepareStatement("select idCliente, nome , CPF from cliente where CPF like ?");
                comando.setString(1, dados + "%");
                rs = comando.executeQuery();

            }

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodCli(rs.getInt("idCliente"));
                pedido.setNomeCli(rs.getString("nome"));
                pedido.setCPFcli(rs.getString("CPF"));
                listaClientes.add(pedido);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaClientes = null;
        } catch (SQLException ex) {
            System.out.println(ex);
            listaClientes = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                listaClientes = null;
            }
        }

        return listaClientes;
    }

    public static ArrayList<Pedido> consultaPedido(String dados, byte tipo) {
        ArrayList<Pedido> listaProduto = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement comando = null;
            ResultSet rs = null;

            //codição para consultar por nome ou CPF, com base no tipo indicado
            if (tipo == 1) {
                comando = conexao.prepareStatement("select idproduto, nome , preco, qtdEstoque from produto where nome like ?");
                comando.setString(1, dados + "%");
                rs = comando.executeQuery();
            } else if (tipo == 2) {
                comando = conexao.prepareStatement("select idproduto, nome , preco, qtdEstoque from produto where idproduto like ?");
                comando.setString(1, dados + "%");
                rs = comando.executeQuery();

            }

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodProd(rs.getInt("idproduto"));
                pedido.setNomeProd(rs.getString("nome"));
                pedido.setValorProd(rs.getDouble("preco"));
                pedido.setQtdProd(rs.getInt("qtdEstoque"));
                listaProduto.add(pedido);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaProduto = null;
        } catch (SQLException ex) {
            System.out.println(ex);
            listaProduto = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                listaProduto = null;
            }
        }

        return listaProduto;
    }

    public static int salvar(Pedido p) {
        int retorno = 0;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO pedido "
                    + "(idpedido,idcliente, total, formPagamento)"
                    + " VALUES(null,?,?,?)");

            comando.setInt(1, p.getCodCli());               //codigo do cliente
            comando.setDouble(2, p.getTotal());             //valor total do pedido
            comando.setString(3, p.getFormPagamento());     //forma de pagamento
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                //Extração do Id do pedido - inicio
                ResultSet rs = null;
                comando = conexao.prepareStatement("select last_insert_id() as idPedido");
                rs = comando.executeQuery();
                while (rs.next()) {
                    retorno = rs.getInt("idPedido");
                }
                //Extração do Id do pedido - Final
            } else {
                retorno = 0;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            retorno = 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = 0;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                retorno = 0;
            }

        }

        return retorno;

    }

}
