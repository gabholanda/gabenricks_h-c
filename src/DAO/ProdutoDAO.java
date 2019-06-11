/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import java.util.ArrayList;
import Models.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author henrique.csousa
 */
public class ProdutoDAO {
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";   //Driver do MySQL - Se mudar o SGBD mude o Driver
    private static final String SERVIDOR = "localhost";                 //servidor de banco de dados
    private static final String BASEDADOS = "lojagabenricks_produto";   //nome da base de dados
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";                   //sua senha de acesso
    private static String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;
    
    /**
     * @see DAO.ProdutoDAO, Views.ProdutosView
     * @param p
     * @return boolean - true: Salvo com sucesso, false: falha ao salvar
     */
    public static boolean salvar(Produto p) {
           boolean retorno = false;
           try {
               Class.forName(DRIVER);
               conexao=DriverManager.getConnection(URL, LOGIN, SENHA);
                Statement comando = conexao.createStatement();
                int linhasAfetadas= comando.executeUpdate("INSERT INTO Produto" +
                        "(Nome,qtdEstoque, preco, fornecedor ) VALUES("
                        + "'"+p.getNome()+"',"+p.getQntEstoque()+","+p.getPreco()+",'"+p.getFornecedor()+"');");
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
   /**
    * @see DAO.ProdutoDAO, Views.ProdutosView
    * @param c
    * @return boolean - true: Salvo com sucesso, false: falha ao salvar
    */
 public static boolean atualizar(Produto c) {
        //Simulo um  UPDATE no banco de dados (UPDATE TabelaXYZ SET...)
        boolean retorno = false;

        try {
            //inserção no banco de dados (INSERT INTO...)
            
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("UPDATE produto SET "
                    + " nome =" + "'" + c.getNome()+ "'" + ","
                    + " qtdEstoque ="  + c.getQntEstoque()+ ","
                    + " preço =" + c.getPreco()+ ","
                    + "fornecedor="+"'"+c.getFornecedor()+"'"+ ","
                    
                    + " WHERE CodProduto =" + c.getIdProduto()+";"
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
 
/**
 * @see DAO.ProdutoDAO, Views.ProdutosView
 * @param CodProduto
 * @return boolean - true: Salvo com sucesso, false: falha ao salvar
 */
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
  /**
   * @see DAO.ProdutoDAO, Views.ProdutosView
   * @param pNome
   * @return lista de cliente, null se houver erros
   */
  public static ArrayList<Produto> consultar(String pNome) {
        ArrayList<Produto> listaClientes = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE ? ");
            comando.setString(1, pNome + "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("clienteId"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("Preco"));
                p.setQntEstoque(rs.getInt("qtdEstoque"));
                p.setFornecedor(rs.getString("telefone"));
                listaClientes.add(p);
            }

        } catch (ClassNotFoundException ex) {
            listaClientes = null;
        } catch (SQLException ex) {
            listaClientes = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaClientes = null;
            }
        }

        return listaClientes;
  }
  /**
   * @see DAO.ProdutoDAO, Views.ProdutosView
   * @return lista de produtos
   */
  
    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> listaRetorno = new ArrayList<>();

        try {

            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);

            //Monto a URL

            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = conexao.createStatement();

            ResultSet rs = comando.executeQuery("SELECT * FROM produto;");

            if (rs != null) {
                while (rs.next()) {
                    Produto c = new Produto();
                    c.setIdProduto(rs.getInt("idProduto"));
                    c.setNome(rs.getString("Nome"));
                    c.setQntEstoque(rs.getInt("qtdEstoque"));
                    c.setPreco(rs.getDouble("Preco"));
                    c.setFornecedor(rs.getString("Fornecedor"));
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