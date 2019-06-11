/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Pedido;
import Models.Relatorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author patrick.chagas
 */
public class RelatorioDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static ArrayList<Pedido> getProdutos(String dataInicio, String dataFinal) {
        ArrayList<Pedido> listaRetorno = new ArrayList<>();

        try {

            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);

            //Monto a URL
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("select idpedido, idcliente, datapedido, total from pedido where datapedido BETWEEN ? and ?");
            comando.setString(1, dataInicio );
            comando.setString(2, dataFinal );

            ResultSet rs = comando.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Pedido c = new Pedido();
                    c.setPedidoId(rs.getInt("idpedido"));
                    c.setCodCli(rs.getInt("idcliente"));
                    c.setData(rs.getString("datapedido"));
                    c.setTotal(rs.getDouble("total"));
                    listaRetorno.add(c);
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println(e);
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            listaRetorno = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                listaRetorno = null;
            }
        }

        return listaRetorno;

    }

}
