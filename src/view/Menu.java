package view;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel{
    //Atributos
    private JLabel titulo;
    private JButton btnSimularVendas;
    private JButton btnProdutos;
    private JButton btnClientes;
    private JButton btnSair;

    //Construtor
    public Menu(){
        //Titulo
        titulo = new JLabel("Mercadinho", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        //titulo.setForeground(new Color(0, 140, 0));        //Tom de verde

        //Botoes
        btnSimularVendas = new JButton("Simular vendas");
        btnProdutos = new JButton("Gerenciar produtos");
        btnClientes = new JButton("Gerenciar clientes");
        btnSair = new JButton("Sair");

        //Layut principal
        setLayout(new BorderLayout());
        
        //Painel dos botoes com grid para empilhar
        JPanel painelBtn = new JPanel(new GridLayout(4,1, 10, 10));
        painelBtn.add(btnSimularVendas);
        painelBtn.add(btnProdutos);
        painelBtn.add(btnClientes);
        painelBtn.add(btnSair);

        //Titulo + botoes
        add(titulo, BorderLayout.NORTH);
        add(painelBtn, BorderLayout.CENTER);
    }

    //Getters
    public JButton getbtnSimularVendas(){ return btnSimularVendas; }
    public JButton getBtnProdutos(){ return btnProdutos; }
    public JButton getBtnClientes(){ return btnClientes; }
    public JButton getBtnSair(){ return btnSair; }
}
