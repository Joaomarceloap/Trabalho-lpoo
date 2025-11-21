package controller;

import view.CadastroCliente;
import view.MainFrame;
import view.TelaClientes;

public class TelaClientesController {
    private TelaClientes view;
    private MainFrame frame;

    public TelaClientesController(TelaClientes view, MainFrame frame) {
        this.view = view;
        this.frame = frame;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnAdicionaCliente().addActionListener(e -> {
            CadastroCliente dialog = new CadastroCliente(frame);
            dialog.setVisible(true);
        });

        view.getBtnExibirInformacoes().addActionListener(e -> {

        });

        view.getBtnExcluirClientes().addActionListener(e -> {

        });

        view.getBtnVoltar().addActionListener(e -> {
            frame.voltarTela();
        });
    }
}
