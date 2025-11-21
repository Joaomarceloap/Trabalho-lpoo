package controller;

import view.MainFrame;
import view.TelaProdutos;

public class TelaProdutosController {
    private TelaProdutos view;
    private MainFrame frame;

    public TelaProdutosController(TelaProdutos view, MainFrame frame) {
        this.view = view;
        this.frame = frame;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInserirProduto().addActionListener(e -> {

        });

        view.getBtnRetirarProduto().addActionListener(e -> {

        });

        view.getBtnVoltar().addActionListener(e -> {
            frame.voltarTela();
        });
    }
}
