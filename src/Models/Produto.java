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
    private double peso;
    private int qntCaixa;
    private String categoria;
    
    public Produto(){
        
    }
    public Produto(int CodProduto,String nome,int qntEstoque, double preco, String fornecedor, double peso, int qntCaixa, String categoria) {
        this.CodProduto=CodProduto;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.nome = nome;
        this.fornecedor=fornecedor;
        this.peso=peso;
        this.qntCaixa=qntCaixa;
        this.categoria=categoria;
    }
     public Produto(String nome,int qntEstoque, double preco, String fornecedor, double peso, int qntCaixa, String categoria) {
        this.CodProduto=CodProduto;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.nome = nome;
        this.fornecedor=fornecedor;
        this.peso=peso;
        this.qntCaixa=qntCaixa;
        this.categoria=categoria;
    }
    

    public Produto(int CodProduto, String nome, int qntEstoque, double preco) {
        this.CodProduto = CodProduto;
        this.nome = nome;
        this.qntEstoque = qntEstoque;
        this.preco = preco;
    }

    public Produto(String nome,int qntEstoque, double preco, String fornecedor, double peso, int qntCaixa) {
        this.qntEstoque = qntEstoque;
        this.nome = nome;
        this.preco = preco;
        this.fornecedor=fornecedor;
        this.peso=peso;
        this.qntCaixa=qntCaixa;
        
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQntCaixa() {
        return qntCaixa;
    }

    public void setQntCaixa(int qntCaixa) {
        this.qntCaixa = qntCaixa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}


