package view;

import java.awt.*;
import javax.swing.*;

public class TelaSimular extends JPanel{
    //Atributos
    private JLabel tituloSimulando;
    private JButton btnNovoCliente;
    private JButton btnVoltar;

    //Constutor
    public TelaSimular(){
        //Titulo
        tituloSimulando = new JLabel("Simulando vendas", SwingConstants.CENTER);
        tituloSimulando.setFont(new Font("Arial", Font.BOLD, 24));

        //Botoes
        btnNovoCliente = new JButton("Adicionar produto");
        btnVoltar = new JButton("Retirar produto");

        //Layout
        setLayout(new BorderLayout());

        //Titulo + botoes + voltar
        add(tituloSimulando, BorderLayout.NORTH);
        add(btnNovoCliente, BorderLayout.EAST);
        add(btnVoltar, BorderLayout.WEST);
    }

    //Getters
    public JButton getBtnNovoCliente(){ return btnNovoCliente; }
    public JButton getBtnVoltar(){ return btnVoltar; }
}
