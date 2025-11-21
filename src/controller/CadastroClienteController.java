package controller;

import javax.swing.JOptionPane;
import view.CadastroCliente;
import model.Cliente;
import model.DAO.ClienteDAO;

public class CadastroClienteController {

    private CadastroCliente view;
    private ClienteDAO clienteDAO;

    public CadastroClienteController(CadastroCliente view) {
        this.view = view;
        this.clienteDAO = new ClienteDAO();

        configurarEventos();
    }

    private void configurarEventos() {

        //Salvar no BD
        view.getBtnSalvar().addActionListener(e -> {

            String nome = view.getNome();
            String cpf = view.getCpf();
            String endereco = view.getEndereco();
            String telefone = view.getTelefone();

            //Cria objeto Cliente
            Cliente novo = new Cliente(nome, cpf, endereco, telefone);

            //Salva no banco via DAO
            clienteDAO.create(novo);

            JOptionPane.showMessageDialog(view, "Cliente cadastrado!");

            view.dispose();
        });

        //Cancelar
        view.getBtnCancelar().addActionListener(e -> {
            view.dispose();
        });
    }
}
