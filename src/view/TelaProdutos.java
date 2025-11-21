package view;

import java.awt.*;
import javax.swing.*;

public class TelaProdutos extends JPanel{
    //Atributos
    private JLabel tituloProdutos;
    private JButton btnInserirProduto;
    private JButton btnRetirarProduto;
    private JButton btnVoltar;

    public TelaProdutos(){
        //Titulo
        tituloProdutos = new JLabel("Produtos", SwingConstants.CENTER);
        tituloProdutos.setFont(new Font("Arial", Font.BOLD, 24));

        //Botoes
        btnInserirProduto = new JButton("Adicionar produto");
        btnRetirarProduto = new JButton("Retirar produto");

        //Layout
        setLayout(new BorderLayout());

        //Painel botoes
        JPanel painelBtnProduto = new JPanel(new GridLayout(2, 1, 10, 10));
        painelBtnProduto.add(btnInserirProduto);
        painelBtnProduto.add(btnRetirarProduto);

        //Titulo + botoes + voltar
        add(tituloProdutos, BorderLayout.NORTH);
        add(painelBtnProduto, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.WEST);
    }

    //Getters
    public JButton getBtnInserirProduto(){ return btnInserirProduto;}
    public JButton getBtnRetirarProduto(){ return btnRetirarProduto;}
    public JButton getBtnVoltar(){ return btnVoltar;}
}
