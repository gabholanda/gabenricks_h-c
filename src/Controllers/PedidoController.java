/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ItemPedido;
import Models.Pedido;
import java.util.ArrayList;

/**
 *
 * @author lucas.paiva
 */
public class PedidoController {

    private ArrayList<ItemPedido> Pedido = new ArrayList<ItemPedido>();

    public PedidoController() {
        
    }

    public void AdicionarItemProduto(ItemPedido produto) {
        Pedido.add(produto);
    }

    public double ValorTotal() {
        double Total = 0.00f;
        for (int i = 0;i<Pedido.size();i++) {
            Total += Pedido.get(i).getValor();
        }
        return Total;
    }

}
