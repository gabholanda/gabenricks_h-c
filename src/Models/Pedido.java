/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author lucas.paiva & patrick Chagas
 */
public class Pedido {

    private static int qtdPedidosCriados;
    private int pedidoId;
    private double Total;
    private int codCli;
    private String nomeCli;
    private String CPFcli;
    private int codProd;
    private String nomeProd;
    private double valorProd;
    private int qtdProd;
    private String formPagamento;
    private String data;

    public Pedido() {
        qtdPedidosCriados++;
        this.pedidoId = qtdPedidosCriados;
    }

    public Pedido(int pedidoId, double Total) {
        this.Total = Total;
        this.pedidoId = pedidoId;
        qtdPedidosCriados++;
    }

    public Pedido(int idCliente, double total, String FormPagamento) {
        this.codCli = idCliente;
        this.Total = total;
        this.formPagamento = FormPagamento;
    }

    public Pedido(String nome) {
        this.nomeCli = nome;

    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getCPFcli() {
        return CPFcli;
    }

    public void setCPFcli(String CPFcli) {
        this.CPFcli = CPFcli;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public String getFormPagamento() {
        return formPagamento;
    }

    public void setFormPagamento(String formPagamento) {
        this.formPagamento = formPagamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
