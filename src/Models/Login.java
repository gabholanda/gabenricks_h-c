/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author patrick.chagas
 */
public class Login {
    private int idLogin;
    private String nome;
    private String usuario;
    private String senha;
    
    
    public Login(int id, String nome, String usuario, String senha){
        this.idLogin = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Login(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
