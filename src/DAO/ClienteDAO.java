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
    private static final String SENHA = "adminadmin";                             //sua senha de acesso
    private static final String URL = "jdbc:mysql://localhost:3306/lojagabenricks?useTimezone=true&serverTimezone=UTC";  //URL do banco de dados
    private static Connection conexao;

    public static boolean salvar(Cliente c) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("INSERT INTO cliente "
                    + "(nome,dataNascimento,CPF,telefone,email,rua,endereco,numero,cep,complemento,cidade,estado,sexo)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            comando.setString(1, c.getNome()); //Posição 1 = nome
            comando.setString(2, c.getDataNascimento()); //Posição 2 = Data de nascimento
            comando.setString(3, c.getCpf()); //Posição 3 = CPF
            comando.setString(4, c.getTelefone()); // Posição 4 = telefone
            comando.setString(5, c.getEmail()); // Posição 5 = email
            comando.setString(6, c.getRua()); // Posição 6 = Tipo rua / avenida e afins
            comando.setString(7, c.getEndereco());// Posição 7 = endereco
            comando.setInt(8, c.getNumero());// Posição 8 = Numero da casa
            comando.setString(9, c.getCep());// Posição 9 = CEP
            comando.setString(10, c.getComplemento());// Posição 10 = Complemento
            comando.setString(11, c.getCidade());// Posição 11 = Cidade
            comando.setString(12, c.getEstado());// Posição 12 = Estado
            comando.setString(13, c.getSexo());
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
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
                    + "nome=?, dataNascimento=?, CPF=?, telefone=?, "
                    + "email=?, rua=?, endereco = ?, numero=?, cep=?, complemento=?, cidade=?, estado=?, sexo=?"
                    + " WHERE idcliente= ?");

            comando.setString(1, c.getNome()); //Posição 1 = nome
            comando.setString(2, c.getDataNascimento()); //Posição 2 = Data de nascimento
            comando.setString(3, c.getCpf()); //Posição 3 = CPF
            comando.setString(4, c.getTelefone()); // Posição 4 = telefone
            comando.setString(5, c.getEmail()); // Posição 5 = email
            comando.setString(6, c.getRua()); // Posição 6 = Tipo rua / avenida e afins
            comando.setString(7, c.getEndereco());// Posição 7 = endereco
            comando.setInt(8, c.getNumero());// Posição 8 = Numero da casa
            comando.setString(9, c.getCep());// Posição 9 = CEP
            comando.setString(10, c.getComplemento());// Posição 10 = Complemento
            comando.setString(11, c.getCidade());// Posição 11 = Cidade
            comando.setString(12, c.getEstado());// Posição 12 = Estado
            comando.setString(13, c.getSexo());// Posição 13 = Sexo
            comando.setInt(14, c.getClienteId());
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
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

        } catch (ClassNotFoundException | SQLException ex) {
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
                c.setClienteId(rs.getInt("idCliente"));
                c.setSexo(rs.getString("sexo"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("Email"));
                c.setRua(rs.getString("rua"));
                c.setEndereco(rs.getString("Endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setCep(rs.getString("cep"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                listaClientes.add(c);
            }

        } catch (ClassNotFoundException | SQLException ex) {
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

    public static ArrayList<Cliente> consultar(String pNome) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ");
            comando.setString(1, pNome + "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setClienteId(rs.getInt("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("Email"));
                c.setRua(rs.getString("rua"));
                c.setEndereco(rs.getString("Endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setCep(rs.getString("cep"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                listaClientes.add(c);
            }

        } catch (ClassNotFoundException | SQLException ex) {
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
                c.setClienteId(rs.getInt("idCliente"));
                c.setSexo(rs.getString("sexo"));
                c.setNome(rs.getString("nome"));
                c.setDataNascimento(rs.getString("dataNascimento"));
                c.setCpf(rs.getString("CPF"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("Email"));
                c.setRua(rs.getString("rua"));
                c.setEndereco(rs.getString("Endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setCep(rs.getString("cep"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                listaClientes.add(c);
            }

        } catch (ClassNotFoundException | SQLException ex) {
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
