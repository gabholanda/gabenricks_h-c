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

    private int idProduto, idPedido, qtdItem;
    private double valorItem;
    
    public ItemPedido() {
    }

    public ItemPedido(int CodProduto, int codPedido,int quantidade, double valor) {
        this.idProduto = CodProduto;
        this.idPedido=codPedido;
        this.qtdItem=quantidade;
        this.valorItem=valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

}
