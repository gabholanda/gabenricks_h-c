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
    public static boolean salvar(String nome, String dataNascimento, String cpf,
            String telefone, String email,
            String rua, String endereco, int numero, String cep, String complemento, String cidade, String estado) {

        Cliente c = new Cliente(nome, dataNascimento, cpf, telefone, email, rua, endereco, numero, cep, complemento, cidade, estado);
        return ClienteDAO.salvar(c);

    }

    public static boolean atualizar(String nome, String dataNascimento, String cpf,
            String telefone, String email,
            String rua, String endereco, int numero, String cep, String complemento, String cidade, String estado) {
        Cliente c = new Cliente(nome, dataNascimento, cpf, telefone, email, rua, endereco, numero, cep, complemento, cidade, estado);
        return ClienteDAO.atualizar(c);
    }

    public static boolean excluir(int clienteId) {
        return ClienteDAO.excluir(clienteId);
    }


    public static ArrayList<Cliente> consultar(String nome) {
        return ClienteDAO.consultar(nome);
    }

    public static ArrayList<String[]> getClientes() {
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getClienteId()),
                clientes.get(i).getNome(),
                String.valueOf(clientes.get(i).getDataNascimento()),
                String.valueOf(clientes.get(i).getCpf()),
                String.valueOf(clientes.get(i).getTelefone()),
                clientes.get(i).getEmail(),
                String.valueOf(clientes.get(i).getRua()),
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
 public static ArrayList<String[]> getConsultaClientes(String info) {
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getClienteId()),
                clientes.get(i).getNome(),
                String.valueOf(clientes.get(i).getDataNascimento()),
                String.valueOf(clientes.get(i).getCpf()),
                String.valueOf(clientes.get(i).getTelefone()),
                clientes.get(i).getEmail(),
                String.valueOf(clientes.get(i).getRua()),
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
