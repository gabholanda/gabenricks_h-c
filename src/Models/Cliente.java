/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author HOLANDAS
 */
public class Cliente {

    private int clienteId;
    private String nome;
    private int cpf;
    private int telefone;
    private int codFidelidade;
    private String email;
    private String endereco;
    private String infoComplementar;

    public Cliente(String nome, int cpf, int codFidelidade) {

        this.nome = nome;
        this.cpf = cpf;
        this.codFidelidade = codFidelidade;
    }

    public Cliente(String nome, int cpf, int telefone, int codFidelidade) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codFidelidade = codFidelidade;
    }

    public Cliente(String nome, int cpf, int telefone, int codFidelidade, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codFidelidade = codFidelidade;
        this.email = email;
    }

    public Cliente(String nome, int cpf, int telefone, int codFidelidade, String email, String endereco) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codFidelidade = codFidelidade;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente(int clienteId, String nome, int cpf, int telefone, int codFidelidade, String email, String endereco, String infoComplementar) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codFidelidade = codFidelidade;
        this.email = email;
        this.endereco = endereco;
        this.infoComplementar = infoComplementar;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInfoComplementar() {
        return infoComplementar;
    }

    public void setInfoComplementar(String infoComplementar) {
        this.infoComplementar = infoComplementar;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCodFidelidade() {
        return codFidelidade;
    }

    public void setCodFidelidade(int codFidelidade) {
        this.codFidelidade = codFidelidade;
    }

}
