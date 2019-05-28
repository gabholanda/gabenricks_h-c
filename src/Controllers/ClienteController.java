/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ClienteDAO;
import Models.Cliente;

/**
 *
 * @author HOLANDAS
 */
public class ClienteController {
    //Salva com todas as informações preenchidas
    public static boolean salvar(int clienteId, String nome, int cpf, int telefone, int codFidelidade, String email, String endereco, String infoComplementar){
        Cliente c = new Cliente(clienteId, nome, cpf, telefone, codFidelidade, email, endereco, infoComplementar);
        return ClienteDAO.salvar(c);
    }
    // A partir deste a complexidade para salvar um cliente diminui
    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade, String email, String endereco){
        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade, email, endereco);
        return ClienteDAO.salvar(c);
    }
    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade, String email){
        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade, email);
        return ClienteDAO.salvar(c);
    }
    public static boolean salvar(String nome, int cpf, int telefone, int codFidelidade){
        Cliente c = new Cliente(nome, cpf, telefone, codFidelidade);
        return ClienteDAO.salvar(c);
    }
    // Esta é a regra minima para cadastrar um cliente
    public static boolean salvar(String nome, int cpf, int telefone){
        Cliente c = new Cliente(nome, cpf, telefone);
        return ClienteDAO.salvar(c);
    }
    public static boolean excluir(int clienteId){
        return ClienteDAO.excluir(clienteId);
    }
}
