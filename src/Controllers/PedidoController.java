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
    /**
     * Consulta os clientes no Banco de Dados
     * @param Nome
     * @param tipo
     * @return uma lista de pedido
     * @throws ClassNotFoundException 
     */
    public static ArrayList<Pedido> getConsultaCliente(String Nome, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Pedido = PedidoDAO.consultaCliente(Nome, tipo);

        return Pedido;

    }
    /**
     *  Consulta os produtos no Banco de dados
     * @see Views.Pedido
     * @see DAO.PedidoDAO
     * @param produto
     * @param tipo
     * @return uma lista de produtos
     * @throws ClassNotFoundException 
     */
    public static ArrayList<Pedido> getConsultaProduto(String produto, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Produto = PedidoDAO.consultaPedido(produto, tipo);

        return Produto;
    }
    /** 
     * @see DAO.PedidoDAO
     * @see Views.PedidosView
     * @param Nome
     * @param tipo
     * @return Uma lista de clientes para a tabela
     * @throws ClassNotFoundException 
     */
    public static ArrayList<String[]> getCliente(String Nome, byte tipo) throws ClassNotFoundException {
        ArrayList<Pedido> Pedido = PedidoDAO.consultaCliente(Nome, tipo);
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < Pedido.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(Pedido.get(i).getCodCli()),
                String.valueOf(Pedido.get(i).getNomeCli()),
                String.valueOf(Pedido.get(i).getCPFcli()),});
        }

        return listaClientes;

    }
/** 
     * @see DAO.PedidoDAO
     * @see Views.PedidosView
     * @param produto
     * @param tipo
     * @return Uma lista de produtos para a tabela
     * @throws ClassNotFoundException 
     */
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
    /**
     * Método para salvar o pedido
     * @see DAO.PedidoDAO
     * @see Views.PedidosView
     * @param idCliente
     * @param total
     * @param FormPagamento
     * @return boolean true: sucesso , false: falha
     */
    public static int salvarPedido(int idCliente, double total, String FormPagamento) {
        //Salvo na memória
        Pedido p = new Pedido(idCliente, total,FormPagamento);
        return PedidoDAO.salvar(p);
    }
    /**
     * Método para salvar item de pedido
     * @param idPoduto
     * @param idPedido
     * @param qtdItem
     * @param valor
     * @return boolean true: sucesso, false: falha
     */
    public static boolean SalvarItemPedido(int idPoduto, int idPedido, int qtdItem, double valor){
        ItemPedido Item = new ItemPedido(idPoduto,idPedido,qtdItem,valor);
        return ItemPedidoDAO.salvar(Item);
    }
}
