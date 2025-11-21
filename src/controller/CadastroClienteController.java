package controller;

import javax.swing.JOptionPane;
import model.Cliente;
import model.DAO.ClienteDAO;
import view.CadastroCliente;

public class CadastroClienteController {

    private CadastroCliente view;
    private ClienteDAO clienteDAO;

    public CadastroClienteController(CadastroCliente view, ClienteDAO clienteDAO) {
        this.view = view;
        this.clienteDAO = clienteDAO;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnSalvar().addActionListener(e -> {

            String nome = view.getNome().trim();
            String cpf = view.getCpf().trim();
            String endereco = view.getEndereco().trim();
            String telefone = view.getTelefone().trim();

            // Validação básica
            if (nome.isEmpty() || cpf.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cliente inicia com pontos = 0; ID será resolvido pelo banco
            Cliente novo = new Cliente(nome, cpf, endereco, telefone, 0, 0);

            clienteDAO.create(novo);

            JOptionPane.showMessageDialog(view, "Cliente cadastrado!");
            view.dispose();
        });

        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }
}
