/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import Models.Produto;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class SimulaDB {

    private static SimulaDB mockdb;

    private ArrayList<Cliente> listaClientes; //Simulo a tabela clientes
    private ArrayList<Produto> listaProdutos; //Simulo a tabela Produtos

    private SimulaDB() {

        listaClientes = new ArrayList<Cliente>();
        listaProdutos = new ArrayList<Produto>();
    }

    public static synchronized SimulaDB getInstance() {
        if (mockdb == null) {
            mockdb = new SimulaDB();
        }

        return mockdb;
    }

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
                item.setCpf(p.getCpf());
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

    public boolean SalvarProduto(Produto c) {
        listaProdutos.add(c);

        return true;
    }

    public ArrayList<Produto> getProdutos() {
        return this.listaProdutos;
    }

    public boolean AtualizarProduto(Produto p) {
        for (Produto item : listaProdutos) {
            if (item.getCodProduto()== p.getCodProduto()) {
                item.setCodProduto(p.getCodProduto());
                item.setNome(p.getNome());
                item.setPreco(p.getPreco());
            }
        }

        return true;
    }

    public boolean ExcluirProduto(int i) {
        Produto produtoExcluir = new Produto();
        boolean existeNaLista = false;
        for (Produto c : listaProdutos) {

            if (c.getCodProduto()== i) {
                produtoExcluir = c;
                existeNaLista = true;
            }
        }

        if (existeNaLista) {
            listaProdutos.remove(produtoExcluir);
        }

        return true;
    }

}

