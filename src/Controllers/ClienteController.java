/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ClienteDAO;
import Models.Cliente;
import java.util.ArrayList;

/**
 *
 * @author HOLANDAS
 */
public class ClienteController {

    //Salva com todas as informações preenchidas
   /**
    * @see DAO.ClienteDAO, Views.ClientesView
    * @param nome
    * @param sexo
    * @param dataNascimento
    * @param cpf
    * @param telefone
    * @param email
    * @param rua
    * @param endereco
    * @param numero
    * @param cep
    * @param complemento
    * @param cidade
    * @param estado
    * @return boolean - true: Sucesso ao cadastrar cliente, false: falha ao cadastrar cliente
    */
    public static boolean salvar(String nome, String sexo, String dataNascimento, String cpf,
            String telefone, String email,
            String rua, String endereco, int numero, String cep, String complemento, String cidade, String estado) {

        Cliente c = new Cliente(nome, sexo, dataNascimento, cpf, telefone, email, rua, endereco, numero, cep, complemento, cidade, estado);
        return ClienteDAO.salvar(c);

    }
 /**
    * @see DAO.ClienteDAO, Views.ClientesView
    * @param nome
    * @param sexo
    * @param dataNascimento
    * @param cpf
    * @param telefone
    * @param email
    * @param rua
    * @param endereco
    * @param numero
    * @param cep
    * @param complemento
    * @param cidade
    * @param estado
    * @return boolean - true: Sucesso ao atualizar cliente, false: falha ao atualizar cliente
    */
    public static boolean atualizar(String nome, String sexo,  String dataNascimento, String cpf,
            String telefone, String email,
            String rua, String endereco, int numero, String cep, String complemento, String cidade, String estado) {
        Cliente c = new Cliente(nome, sexo, dataNascimento, cpf, telefone, email, rua, endereco, numero, cep, complemento, cidade, estado);
        return ClienteDAO.atualizar(c);
    }
/**
 * @see DAO.ClienteDAO, Views.ClientesView
 * @param clienteId
 * @return boolean - true: Sucesso ao excluir cliente, false: falha ao atualizar cliente
 */
    public static boolean excluir(int clienteId) {
        return ClienteDAO.excluir(clienteId);
    }

    /**
     * @see DAO.ClienteDAO, Views.ClientesView
     * @param nome
     * @return Lista de clientes consultada.
     */
    public static ArrayList<Cliente> consultar(String nome) {
        return ClienteDAO.consultar(nome);
    }
     /**
      * @see DAO.ClienteDAO, Views.ClientesView
      * @return Lista de clientes do BD
      */
    public static ArrayList<String[]> getClientes() {
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getClienteId()),
                clientes.get(i).getNome(),
                clientes.get(i).getSexo(),
                clientes.get(i).getDataNascimento(),
                clientes.get(i).getCpf(),
                clientes.get(i).getTelefone(),
                clientes.get(i).getEmail(),
                clientes.get(i).getRua(),
                clientes.get(i).getEndereco(),
                String.valueOf(clientes.get(i).getNumero()),
                clientes.get(i).getCep(),
                clientes.get(i).getComplemento(),
                clientes.get(i).getCidade(),
                clientes.get(i).getEstado()
            });

        }

        return listaClientes;

    }
     /**
      * @see DAO.ClienteDAO, Views.ClientesView
      * @param info
      * @return Retorna a lista consultada de clientes.
      */
 public static ArrayList<String[]> getConsultaClientes(String info) {
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getClienteId()),
                clientes.get(i).getNome(),
                clientes.get(i).getSexo(),
                clientes.get(i).getDataNascimento(),
                clientes.get(i).getCpf(),
                clientes.get(i).getTelefone(),
                clientes.get(i).getEmail(),
                clientes.get(i).getRua(),
                clientes.get(i).getEndereco(),
                String.valueOf(clientes.get(i).getNumero()),
                String.valueOf(clientes.get(i).getCep()),
                clientes.get(i).getComplemento(),
                clientes.get(i).getCidade(),
                clientes.get(i).getEstado()
            });

        }

        return listaClientes;

    }
}
