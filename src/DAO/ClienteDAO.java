/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HOLANDAS
 */
public class ClienteDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    //Driver do MySQL 8.0 em diante - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root";                         //nome de um usuário do banco de dados
    private static final String SENHA = "";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static boolean salvar(Cliente c) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO cliente "
                    + "(nome,CPF,telefone,codFidelidade,email,endereco,infoComplementar)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)");

            comando.setString(1, c.getNome()); //Posição 1 = nome
            comando.setInt(2, c.getCpf()); //Posição 2 = CPF
            comando.setInt(3, c.getTelefone()); // Posição 3 = telefone
            comando.setInt(4, c.getCodFidelidade()); // Posição 4 = codFidelidade
            comando.setString(5, c.getEmail()); // Posição 5 = email
            comando.setString(6, c.getEndereco()); // Posição 6 = endereco
            comando.setString(7, c.getInfoComplementar()); // Posição 7 = informações complementares
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

    public static boolean atualizar(Cliente c) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("UPDATE cliente SET "
                    + "nome=?, CPF=?, telefone=?, "
                    + "email=?, endereco = ?, infoComplementar = ?"
                    + " WHERE idcliente= ?");

            comando.setString(1, c.getNome());
            comando.setInt(2, c.getCpf());
            comando.setInt(3, c.getTelefone());
            comando.setString(4, c.getEmail());
            comando.setString(5, c.getEndereco());
            comando.setString(6, c.getInfoComplementar());
            comando.setInt(7, c.getClienteId());
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

    public static boolean excluir(int clienteId) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM cliente WHERE idcliente= ?");

            comando.setInt(1, clienteId);

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
// Consultar via CPF
    public static ArrayList<Cliente> consultar(int cpf) {

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf LIKE ? ");
            comando.setString(1, cpf + "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setClienteId(rs.getInt("clienteId"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setEndereco(rs.getString("Endereco"));
                c.setTelefone(rs.getInt("telefone"));
                c.setInfoComplementar("InfoComplementar");
                listaClientes.add(c);
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
//Consultar via Nome
    public static ArrayList<Cliente> consultar(String pNome) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            //return SimulaDB.getInstance().getClientes();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
//            Statement comando = conexao.createStatement();
//            ResultSet rs = comando.executeQuery("SELECT * FROM cliente;");
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ");
            comando.setString(1, pNome + "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setClienteId(rs.getInt("clienteId"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setEndereco(rs.getString("Endereco"));
                c.setTelefone(rs.getInt("telefone"));
                c.setInfoComplementar("InfoComplementar");
                listaClientes.add(c);
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
//Retorna a lista de clientes
    public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setClienteId(rs.getInt("clienteId"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setEndereco(rs.getString("Endereco"));
                c.setTelefone(rs.getInt("telefone"));
                c.setInfoComplementar("InfoComplementar");
                listaClientes.add(c);
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
}
