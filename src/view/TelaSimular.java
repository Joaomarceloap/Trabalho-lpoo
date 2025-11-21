package view;

import java.awt.*;
import javax.swing.*;

public class TelaSimular extends JPanel {

    private JLabel titulo;

    // Campos
    private JComboBox<String> comboClientes;
    private JComboBox<String> comboProdutos;
    private JTextField campoQuantidade;

    // Botões
    private JButton btnSimular;
    private JButton btnConfirmar;
    private JButton btnVoltar;

    public TelaSimular() {

        titulo = new JLabel("Simulação de Venda", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        comboClientes = new JComboBox<>();
        comboProdutos = new JComboBox<>();
        campoQuantidade = new JTextField();

        btnSimular = new JButton("Simular");
        btnConfirmar = new JButton("Confirmar Venda");
        btnVoltar = new JButton("Voltar");

        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        painelForm.add(new JLabel("Cliente:"));
        painelForm.add(comboClientes);

        painelForm.add(new JLabel("Produto:"));
        painelForm.add(comboProdutos);

        painelForm.add(new JLabel("Quantidade:"));
        painelForm.add(campoQuantidade);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 10, 10));
        painelBotoes.add(btnSimular);
        painelBotoes.add(btnConfirmar);
        painelBotoes.add(btnVoltar);

        add(titulo, BorderLayout.NORTH);
        add(painelForm, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    // GETTERS
    public JComboBox<String> getComboClientes() { return comboClientes; }
    public JComboBox<String> getComboProdutos() { return comboProdutos; }
    public JTextField getCampoQuantidade() { return campoQuantidade; }

    public JButton getBtnSimular() { return btnSimular; }
    public JButton getBtnConfirmar() { return btnConfirmar; }
    public JButton getBtnVoltar() { return btnVoltar; }

    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
