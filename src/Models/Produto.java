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

    private int CodProduto;
    private String nome;
    private int qntEstoque;
    private double preco;
    private String fornecedor;
    private static int qtdProdutosCriados;

    public Produto() {
        qtdProdutosCriados++;
        this.CodProduto = qtdProdutosCriados;
    }

    public Produto(int CodProduto, String nome, int qntEstoque, double preco, String fornecedor) {
        this.CodProduto = CodProduto;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.nome = nome;
        this.fornecedor = fornecedor;
        qtdProdutosCriados++;
    }

    public Produto(String nome, int qntEstoque, double preco, String fornecedor) {
        this.CodProduto = CodProduto;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.nome = nome;
        this.fornecedor = fornecedor;
        qtdProdutosCriados++;
    }

    public Produto(int CodProduto, String nome, int qntEstoque, double preco) {
        this.CodProduto = CodProduto;
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.preco = preco;
        qtdProdutosCriados++;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

}
