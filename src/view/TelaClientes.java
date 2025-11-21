package view;

import java.awt.*;
import javax.swing.*;

public class TelaClientes extends JPanel {
    private JLabel tituloCliente;
    private JButton btnAdicionaCliente;
    private JButton btnVoltar;

    public TelaClientes() {
        // Título
        tituloCliente = new JLabel("Clientes", SwingConstants.CENTER);
        tituloCliente.setFont(new Font("Arial", Font.BOLD, 24));

        // Botões
        btnAdicionaCliente = new JButton("Adicionar Cliente");
        btnVoltar = new JButton("Voltar");

        // Layout principal
        setLayout(new BorderLayout());

        // Painel central com os botões
        JPanel painelCentral = new JPanel(new GridLayout(2, 1, 20, 20));
        painelCentral.add(btnAdicionaCliente);
        painelCentral.add(btnVoltar);

        // Montagem da tela
        add(tituloCliente, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);
    }

    // Getters
    public JButton getBtnAdicionaCliente() { return btnAdicionaCliente; }
    public JButton getBtnVoltar() { return btnVoltar; }
}
