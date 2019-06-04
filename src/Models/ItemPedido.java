/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author lucas.paiva
 */
public class ItemPedido {

    private int quantidade,valor, produtoId, pedidoId, itempedidoId;
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(int produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public ItemPedido(int itemPedidoId, int produtoId, int pedidoId, int quantidade) {
        this.produtoId = produtoId;
        this.pedidoId = pedidoId;
        this.quantidade = quantidade;

    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getItempedidoId() {
        return itempedidoId;
    }

    public void setItempedidoId(int itempedidoId) {
        this.itempedidoId = itempedidoId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
