package view;

import java.awt.*;
import javax.swing.*;

public class TelaClientes extends JPanel{
    private JLabel tituloCliente;
    private JButton btnAdicionaCliente;
    private JButton btnExibirInformacoes;
    private JButton btnExcluirClientes;
    private JButton btnVoltar;

    public TelaClientes(){
        //Titulo
        tituloCliente = new JLabel("Clientes", SwingConstants.CENTER);
        tituloCliente.setFont(new Font("Arial", Font.BOLD, 24));

        //Botoes
        btnAdicionaCliente = new JButton("Adicionar cliente");
        btnExibirInformacoes = new JButton("Exibir informações");
        btnExcluirClientes = new JButton("Excluir clientes");

        //Layout
        setLayout(new BorderLayout());

        //Painel botoes
        JPanel painelBtnCliente = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBtnCliente.add(btnAdicionaCliente);
        painelBtnCliente.add(btnExibirInformacoes);
        painelBtnCliente.add(btnExcluirClientes);

        //Titulo + botoes + voltar
        add(tituloCliente, BorderLayout.NORTH);
        add(painelBtnCliente, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.WEST);
    }

    //Getters
    public JButton getBtnAdicionaCliente(){ return btnAdicionaCliente; }
    public JButton getBtnExibirInformacoes(){ return btnExibirInformacoes; }
    public JButton getBtnExcluirClientes(){ return btnExcluirClientes; }
    public JButton getBtnVoltar(){ return btnVoltar; }
}