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
public class Produto {

    private int produtoId;
    private String nome;
    private int qntEstoque;
    private double preco;

    public Produto(double preco, int qntEstoque, String nome) {
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.nome = nome;
    }

    public Produto(int produtoId, String nome, int qntEstoque, double preco) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.preco = preco;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
