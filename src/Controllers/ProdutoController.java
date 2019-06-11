/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ProdutoDAO;
import Models.Produto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author henrique.csousa
 */
public class ProdutoController {

    public static boolean salvar(String nome, int qntEstoque, double preco, String fornecedor) {
        //Salvo na memória
        Produto p = new Produto(nome, qntEstoque, preco, fornecedor);
        return ProdutoDAO.salvar(p);
    }

    public static boolean excluir(int pIdProduto) {
        return ProdutoDAO.excluir(pIdProduto);
    }

    public static boolean atualizar(String nome,  double preco, int qntEstoque, String fornecedor) {
        Produto p = new Produto();
        return ProdutoDAO.atualizar(p);
    }
    
    
       public static ArrayList<Produto> consultar(String nome) {
        return ProdutoDAO.consultar(nome);
    } 
    

    /**
     * Transformo uma lista de objetos Cliente em uma lista de Strings
     *
     * @return lista de string
     */
    public static ArrayList<String[]> getProduto() {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{ String.valueOf(produtos.get(i).getIdProduto()),
                String.valueOf(produtos.get(i).getNome()),
                String.valueOf(produtos.get(i).getPreco()),
                String.valueOf(produtos.get(i).getQntEstoque()),
                produtos.get(i).getFornecedor()
            });
        }

        return listaProdutos;

    }

    public static ArrayList<Produto> getConsultaProduto() {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();

        return produtos;

    }
//Incompleto
//    public static ArrayList<Produto> consultar(String nome) {
//        return ProdutoDAO.consultar(nome);
//    }
}
