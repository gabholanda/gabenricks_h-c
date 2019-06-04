/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import Models.Produto;
import Models.Pedido;
import Models.ItemPedido;
import java.util.ArrayList;

/**
 *
 * @author fernando.fernandes Padrão Singleton
 */
public class SimulaDB {

    private static SimulaDB mockdb;

    private ArrayList<Cliente> listaClientes; //Simulo a tabela clientes
    private ArrayList<Produto> listaProdutos; //Simulo a tabela Produtos
    private ArrayList<Pedido> listaPedidos; //Simulo a tabela Pedidos
    private ArrayList<ItemPedido> listaItemPedido; //Simulo a tabela ItemPedido

    private SimulaDB() {

        listaClientes = new ArrayList<Cliente>();
        listaProdutos = new ArrayList<Produto>();
        listaPedidos = new ArrayList<Pedido>();
        listaItemPedido = new ArrayList<ItemPedido>();
    }

    public static synchronized SimulaDB getInstance() {
        if (mockdb == null) {
            mockdb = new SimulaDB();
        }

        return mockdb;
    }

    //===========================================================  Tabela de Clientes - Inicio =================================================
    public boolean SalvarCliente(Cliente c) {
        listaClientes.add(c);

        return true;
    }

    public ArrayList<Cliente> getClientes() {
        return this.listaClientes;
    }

    public boolean AtualizarCliente(Cliente p) {
        for (Cliente item : listaClientes) {
            if (item.getClienteId() == p.getClienteId()) {
                item.setNome(p.getNome());
                item.setDataNascimento(p.getDataNascimento());
                item.setCpf(p.getCpf());
                item.setEmail(p.getEmail());
                item.setTelefone(p.getTelefone());
                item.setRua(p.getEndereco());
                item.setEndereco(p.getEndereco());
                item.setNumero(p.getNumero());
                item.setComplemento(p.getComplemento());
                item.setCidade(p.getCidade());
                item.setEstado(p.getEstado());
                item.setCep(p.getCep());

            }
        }

        return true;
    }

    public boolean ExcluirCliente(int i) {
        Cliente clienteExcluir = new Cliente();
        boolean existeNaLista = false;
        for (Cliente c : listaClientes) {

            if (c.getClienteId() == i) {
                clienteExcluir = c;
                existeNaLista = true;
            }
        }

        if (existeNaLista) {
            listaClientes.remove(clienteExcluir);
        }

        return true;
    }
    //===========================================================  Tabela de Clientes - Final =================================================

    //===========================================================  Tabela de Produtos - Incio =================================================
    public boolean SalvarProduto(Produto c) {
        listaProdutos.add(c);

        return true;
    }

    public ArrayList<Produto> getProdutos() {
        return this.listaProdutos;
    }

    public boolean AtualizarProduto(Produto p) {
        for (Produto item : listaProdutos) {
            if (item.getCodProduto() == p.getCodProduto()) {
                item.setNome(p.getNome());
                item.setPreco(p.getPreco());
                item.setQntEstoque(p.getQntEstoque());
                item.setFornecedor(p.getFornecedor());

            }
        }

        return true;
    }

    public boolean ExcluirProduto(int i) {
        Produto produtoExcluir = new Produto();
        boolean existeNaLista = false;
        for (Produto c : listaProdutos) {

            if (c.getCodProduto() == i) {
                produtoExcluir = c;
                existeNaLista = true;
            }
        }

        if (existeNaLista) {
            listaProdutos.remove(produtoExcluir);
        }

        return true;
    }

    //===========================================================  Tabela de Produtos - Final =================================================
    //===========================================================  Tabela de Pedidos - Incio =================================================
    public boolean SalvarPedido(Pedido c) {
        listaPedidos.add(c);

        return true;
    }

    public ArrayList<Pedido> getPedidos() {
        return this.listaPedidos;
    }

    public boolean AtualizarPedido(Pedido p) {
        for (Pedido item : listaPedidos) {
            if (item.getPedidoId() == p.getPedidoId()) {
                item.setTotal(p.getTotal());

            }
        }

        return true;
    }

    public boolean ExcluirPedido(int i) {
        Pedido PedidoExcluir = new Pedido();
        boolean existeNaLista = false;
        for (Pedido c : listaPedidos) {

            if (c.getPedidoId() == i) {
                PedidoExcluir = c;
                existeNaLista = true;
            }
        }

        if (existeNaLista) {
            listaPedidos.remove(PedidoExcluir);
        }

        return true;
    }

    //===========================================================  Tabela de Pedidos - Final =================================================
    //===========================================================  Tabela de ItemPedidos - Incio =================================================
    public boolean SalvarItemPedido(ItemPedido c) {
        listaItemPedido.add(c);

        return true;
    }

    public ArrayList<ItemPedido> getItemPedido() {
        return this.listaItemPedido;
    }

    public boolean AtualizarItemPedido(ItemPedido p) {
        for (ItemPedido item : listaItemPedido) {
            if (item.getItempedidoId() == p.getItempedidoId()) {
                item.setPedidoId(p.getPedidoId());
                item.setProduto(p.getProduto());
                item.setProdutoId(p.getProdutoId());
                item.setQuantidade(p.getQuantidade());

            }
        }

        return true;
    }

    public boolean ExcluirItemPedido(int i) {
        ItemPedido ItemPedidoExcluir = new ItemPedido();
        boolean existeNaLista = false;
        for (ItemPedido c : listaItemPedido) {

            if (c.getPedidoId() == i) {
                ItemPedidoExcluir = c;
                existeNaLista = true;
            }
        }

        if (existeNaLista) {
            listaItemPedido.remove(ItemPedidoExcluir);
        }

        return true;
    }

    //===========================================================  Tabela de ItemPedido - Final =================================================
}
