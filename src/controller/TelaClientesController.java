package controller;

import model.DAO.ClienteDAO;
import view.CadastroCliente;
import view.MainFrame;
import view.TelaClientes;

public class TelaClientesController {

    private TelaClientes view;
    private MainFrame frame;
    private ClienteDAO clienteDAO;

    public TelaClientesController(TelaClientes view, MainFrame frame, ClienteDAO clienteDAO) {
        this.view = view;
        this.frame = frame;
        this.clienteDAO = clienteDAO;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnAdicionaCliente().addActionListener(e -> {
            CadastroCliente dialog = new CadastroCliente(frame);

            // Agora sim: cria o controller do dialog
            new CadastroClienteController(dialog, clienteDAO);

            dialog.setVisible(true);
        });

        view.getBtnVoltar().addActionListener(e -> {
            frame.voltarTela();
        });
    }
}
