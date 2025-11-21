package view;

import java.awt.*;
import javax.swing.*;

public class TelaProdutos extends JPanel {

    // Título
    private JLabel tituloProdutos;

    // Campos
    private JTextField campoId;
    private JTextField campoNome;
    private JTextField campoPreco;
    private JTextField campoQtd;

    // Botões principais
    private JButton btnInserirProduto;
    private JButton btnRetirarProduto;
    private JButton btnVoltar;

    // Botões de ordenação
    private JButton btnOrdenarNome;
    private JButton btnOrdenarPreco;
    private JButton btnOrdenarEstoque;

    public TelaProdutos() {

        // Título
        tituloProdutos = new JLabel("Produtos", SwingConstants.CENTER);
        tituloProdutos.setFont(new Font("Arial", Font.BOLD, 24));

        // Criar campos
        campoId = new JTextField();
        campoNome = new JTextField();
        campoPreco = new JTextField();
        campoQtd = new JTextField();

        // Criar botões principais
        btnInserirProduto = new JButton("Adicionar Produto");
        btnRetirarProduto = new JButton("Retirar Produto");
        btnVoltar = new JButton("Voltar");

        // Criar botões de ordenação
        btnOrdenarNome = new JButton("Ordenar por Nome");
        btnOrdenarPreco = new JButton("Ordenar por Preço");
        btnOrdenarEstoque = new JButton("Ordenar por Estoque");

        // Layout principal
        setLayout(new BorderLayout());

        // Painel central (formulário)
        JPanel painelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        painelForm.add(new JLabel("ID:"));
        painelForm.add(campoId);

        painelForm.add(new JLabel("Nome:"));
        painelForm.add(campoNome);

        painelForm.add(new JLabel("Preço:"));
        painelForm.add(campoPreco);

        painelForm.add(new JLabel("Quantidade:"));
        painelForm.add(campoQtd);

        // Painel de botões principais
        JPanel painelBtn = new JPanel(new GridLayout(1, 3, 10, 10));
        painelBtn.add(btnInserirProduto);
        painelBtn.add(btnRetirarProduto);
        painelBtn.add(btnVoltar);

        // Painel de ordenação
        JPanel painelOrdenacao = new JPanel(new GridLayout(1, 3, 10, 10));
        painelOrdenacao.add(btnOrdenarNome);
        painelOrdenacao.add(btnOrdenarPreco);
        painelOrdenacao.add(btnOrdenarEstoque);

        // Painel inferior
        JPanel painelSul = new JPanel(new GridLayout(2, 1, 10, 10));
        painelSul.add(painelBtn);
        painelSul.add(painelOrdenacao);

        // Montagem final
        add(tituloProdutos, BorderLayout.NORTH);
        add(painelForm, BorderLayout.CENTER);
        add(painelSul, BorderLayout.SOUTH);
    }

    // GETTERS
    public JButton getBtnInserirProduto() { return btnInserirProduto; }
    public JButton getBtnRetirarProduto() { return btnRetirarProduto; }
    public JButton getBtnVoltar() { return btnVoltar; }

    public JButton getBtnOrdenarNome() { return btnOrdenarNome; }
    public JButton getBtnOrdenarPreco() { return btnOrdenarPreco; }
    public JButton getBtnOrdenarEstoque() { return btnOrdenarEstoque; }

    public JTextField getCampoId() { return campoId; }
    public JTextField getCampoNome() { return campoNome; }
    public JTextField getCampoPreco() { return campoPreco; }
    public JTextField getCampoQtd() { return campoQtd; }

    // Método auxiliar para mensagens
    public void exibirMensagem(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
}
