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
    public static boolean salvar(String nome,int qntEstoque, double preco, String fornecedor, double peso, int qntCaixa, String categoria)
    {
        //Salvo na memória
            Produto p =  new Produto(qntEstoque, nome, qntEstoque, preco, fornecedor, peso, qntCaixa, categoria);
        return ProdutoDAO.salvar(p);
    }
           

    public static boolean excluir(int pIdProduto)
    {
        return ProdutoDAO.excluir(pIdProduto);
    }
    
    public static boolean adicionar(String nome,int qntEstoque, double preco, String fornecedor, double peso, int qntCaixa,String categoria)
    {
    	Produto p =  new Produto( );
        return ProdutoDAO.adicionar(p);
        
    }
    
    /**
     * Transformo uma lista de objetos Cliente em uma lista de Strings
     * @return lista de string
     */
    public static ArrayList<String[]> getProduto() throws SQLException
    {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i=0;i<produtos.size();i++)
        {
        	listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getCodProduto()),produtos.get(i).getNome(),
                produtos.get(i).getFornecedor(),String.valueOf(produtos.get(i).getQntEstoque()), 
                String.valueOf(produtos.get(i).getQntCaixa()),String.valueOf(produtos.get(i).getPeso()),
                String.valueOf(produtos.get(i).getPreco()),produtos.get(i).getCategoria()});
        
        }
        
        return listaProdutos;
        
    }
}

