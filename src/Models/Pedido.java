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
public class Pedido {
private static int qtdPedidosCriados;
    private int pedidoId;
    private double Total;
    private Cliente cliente;
    
    
    public Pedido() {
      qtdPedidosCriados++;
        this.pedidoId = qtdPedidosCriados;
    }

    public Pedido(int pedidoId, double Total) {
        this.Total = Total;
        this.pedidoId = pedidoId;
        qtdPedidosCriados++;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.cliente = cliente;
    }

    
}
