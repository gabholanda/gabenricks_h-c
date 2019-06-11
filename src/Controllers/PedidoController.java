/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ItemPedidoDAO;
import DAO.PedidoDAO;
import Models.ItemPedido;
import Models.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Patrick Chagas
 */
public class PedidoController {

    private ArrayList<ItemPedido> Pedido = new ArrayList<ItemPedido>();

    public PedidoController() {

    }

    public static ArrayList<Pedido> getConsultaCliente(String Nome, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Pedido = PedidoDAO.consultaCliente(Nome, tipo);

        return Pedido;

    }

    public static ArrayList<Pedido> getConsultaProduto(String produto, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Produto = PedidoDAO.consultaPedido(produto, tipo);

        return Produto;
    }

    public static ArrayList<String[]> getCliente(String Nome, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Pedido = PedidoDAO.consultaCliente(Nome, tipo);
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < Pedido.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(Pedido.get(i).getCodCli()),
                String.valueOf(Pedido.get(i).getNomeCli()),
                String.valueOf(Pedido.get(i).getCPFcli()),});
        }

        return listaProdutos;

    }

    public static ArrayList<String[]> getProduto(String produto, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Produto = PedidoDAO.consultaPedido(produto, tipo);
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < Produto.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(Produto.get(i).getCodProd()),
                String.valueOf(Produto.get(i).getNomeProd()),
                String.valueOf(Produto.get(i).getValorProd()).replaceAll("\\.", ","),
                String.valueOf(Produto.get(i).getQtdProd()),});
        }

        return listaProdutos;
    }

    public static int salvarPedido(int idCliente, double total, String FormPagamento) {
        //Salvo na memória
        Pedido p = new Pedido(idCliente, total,FormPagamento);
        return PedidoDAO.salvar(p);
    }
    
    public static boolean SalvarItemPedido(int idPoduto, int idPedido, int qtdItem, double valor){
        ItemPedido Item = new ItemPedido(idPoduto,idPedido,qtdItem,valor);
        return ItemPedidoDAO.salvar(Item);
    }
}
