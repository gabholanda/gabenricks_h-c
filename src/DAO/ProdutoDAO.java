/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Produto;

/**
 *
 * @author henrique.csousa
 */
public class ProdutoDAO {
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";       //Driver do MySQL - Se mudar o SGBD mude o Driver
    private static final String SERVIDOR = "localhost";                 //servidor de banco de dados
    private static final String BASEDADOS = "lojacarro";                  //nome da base de dados
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static String URL = "jdbc:mysql://localhost:3306/lojacarro?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    public static boolean salvar(Produto p) {
           boolean retorno = false;
           try {
               Class.forName(DRIVER);
               conexao=DriverManager.getConnection(URL, LOGIN, SENHA);
                Statement comando = conexao.createStatement();
                int linhasAfetadas= comando.executeUpdate("INSERT INTO Produto" +
                        "(Nome,qntEstoque, preco, fornecedor, peso, qntCaixa) VALUES("
                        + "'"+p.getNome()+"',"+p.getQntEstoque()+","+p.getPreco()+",'"+p.getFornecedor()+"',"
                               +p.getPeso()+","+p.getQntCaixa()+"'"+p.getCategoria()+"');");
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
   
 public static boolean adicionar(Produto c) {
        //Simulo um  UPDATE no banco de dados (UPDATE TabelaXYZ SET...)
        boolean retorno = false;

        try {
            //inserção no banco de dados (INSERT INTO...)
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("UPDATE carro SET "
                    + " nome =" + "'" + c.getNome()+ "'" + ","
                    + " qntEstoque ="  + c.getQntEstoque()+ ","
                    + " preço =" + c.getPreco()+ ","
                    + "fornecedor="+"'"+c.getFornecedor()+"'"+ ","
                    + "peso=" + c.getPeso()+ ","
                    + "qntCaixas="+c.getQntCaixa()+","
                    + "categoria="+c.getCategoria()
                    + " WHERE CodProduto =" + c.getCodProduto()+";"
            );

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
 

 public static boolean excluir(int CodProduto) {
        // exclusão no banco de dados (DELETE FROM TabelaXYZ WHERE...)
        
        boolean retorno = false;

        try {
            // inserção no banco de dados (INSERT INTO...)
           
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("DELETE FROM produto "
                    + " WHERE CodProduto =" + CodProduto
            );

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

    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> listaRetorno = new ArrayList<>();

        try {

            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);

            //Monto a URL

            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM carro;");

            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setCodProduto(rs.getInt("CodProduto"));
                    c.setNome(rs.getString("Nome"));
                    c.setQntEstoque(rs.getInt("qntEstoque"));
                    c.setPreco(rs.getDouble("Preco"));
                    c.setPeso(rs.getDouble("Peso"));
                    c.setQntCaixa(rs.getInt("qntCaixa"));
                    c.setFornecedor(rs.getString("Fornecedor"));
                    c.setCategoria(rs.getString("categoria"));
                    listaRetorno.add(c);
                }
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {
            listaRetorno = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaRetorno = null;
            }
        }

        return listaRetorno;

    }
       
}
