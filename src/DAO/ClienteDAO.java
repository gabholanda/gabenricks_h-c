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
    
    public static boolean salvar(Cliente c){
        return false;
    }
    public static boolean atualizar (Cliente c){
        return false;
    }
    public static boolean excluir(int clienteId){
        
        return false;
    }
    public static ArrayList <Cliente> consultar(int cpf){
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            //return SimulaDB.getInstance().getClientes();
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
//            Statement comando = conexao.createStatement();
//            ResultSet rs = comando.executeQuery("SELECT * FROM cliente;");

            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ? ");
            comando.setString(1, cpf + "%");

            ResultSet rs = comando.executeQuery();

            while(rs.next())
            {
                Cliente c = new Cliente();
                c.setClienteId(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getInt("CPF"));
                listaClientes.add(c);
            }
            
        } catch (ClassNotFoundException ex) {
            listaClientes = null;
        } catch (SQLException ex) {
            listaClientes = null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaClientes = null;
            }
        }
        
        return listaClientes;
    }
    
}