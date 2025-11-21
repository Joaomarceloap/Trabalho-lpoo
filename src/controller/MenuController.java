package controller;

import view.MainFrame;
import view.Menu;
import view.TelaClientes;
import view.TelaProdutos;
import view.TelaSimular;

public class MenuController {

    private Menu view;
    private MainFrame frame;

    public MenuController(Menu view, MainFrame frame) {
        this.view = view;
        this.frame = frame;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getbtnSimularVendas().addActionListener(e -> {
            TelaSimular tela = new TelaSimular();
            new TelaSimularController(tela, frame);
            frame.trocarTela(tela);

            System.out.println("Simular dia clicado!");
        });

        view.getBtnProdutos().addActionListener(e -> {
            TelaProdutos tela = new TelaProdutos();
            new TelaProdutosController(tela, frame);
            frame.trocarTela(tela);

            System.out.println("Produtos clicado!");
        });

        view.getBtnClientes().addActionListener(e -> {
            TelaClientes tela = new TelaClientes();
            new TelaClientesController(tela, frame);
            frame.trocarTela(tela);

            System.out.println("Clientes clicado!");
        });

        view.getBtnSair().addActionListener(e -> {
            System.exit(0);
        });
    }
}
