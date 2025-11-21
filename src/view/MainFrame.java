package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel ultimaTela;

    public MainFrame() {

        setTitle("Sistema do Mercadinho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);        // Tamanho da janela
        setLocationRelativeTo(null);    // Centraliza na tela
    }

    public void trocarTela(JPanel novaTela) {

        // Salva a última tela antes de trocar
        if (getContentPane().getComponentCount() > 0) {
            ultimaTela = (JPanel) getContentPane().getComponent(0);
        }

        // Troca a tela corretamente
        setContentPane(novaTela);
        revalidate();
        repaint();
    }

    public void voltarTela() {
        if (ultimaTela != null) {
            setContentPane(ultimaTela);
            revalidate();
            repaint();
        }
    }
}