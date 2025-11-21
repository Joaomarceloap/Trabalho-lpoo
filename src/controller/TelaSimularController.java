package controller;

import view.MainFrame;
import view.TelaSimular;

public class TelaSimularController {
    private TelaSimular view;
    private MainFrame frame;

    public TelaSimularController(TelaSimular view, MainFrame frame) {
        this.view = view;
        this.frame = frame;

        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnNovoCliente().addActionListener(e -> {

        });

        view.getBtnVoltar().addActionListener(e -> {
            frame.voltarTela();
        });
    }
}
