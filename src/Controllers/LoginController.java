/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ModuloConexao;
import Views.PrincipalView;
import Views.TelaLoginView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author patrick.chagas
 */
public class LoginController {

    Connection conexao = null;

    public boolean login(String login, String senha) throws SQLException {
        conexao = ModuloConexao.conector();
        // criando variáveis especiais para conexão com o banco
        //Prepared Statement e ResultSet são frameworks do pacote java.sql
        // e servem para preparar e executar as instruções SQL
        PreparedStatement pst = null;
        ResultSet rs = null;

        //Usado chave para descriptogravar os dados SENACPI2019
        String Chave_cryptografia = "SENACPI2019";
        String sql = "select login, CAST(AES_DECRYPT(senha,'SENAC') as char) from usuarios "
                + "where login = ? and senha = AES_ENCRYPT(?,'" + Chave_cryptografia + "')";
        try {
            //as linhas abaixo preparam a consulta em função do que foi 
            //digitado nas caixas de texto. O ? é substituído pelo conteúdo
            //das variáveis que são armazenadas em pst.setString
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);
            //a linha abaixo executa a query(consulta)
            rs = pst.executeQuery();
            //se existir um usuário e senha correspondente
            if (rs.next()) {
                //direcionamento para tela principal, apos o usuario ser aprovado
                PrincipalView TelaPrincipal = new PrincipalView();
                TelaPrincipal.setVisible(true);

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}
