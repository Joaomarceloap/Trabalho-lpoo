package view;

import javax.swing.*;
import java.awt.Component; // Import necessário

public class MainFrame extends JFrame {

    // MUDANÇA 1: Agora é 'Component', aceita Painel, Label, Botão, etc.
    private Component ultimaTela;

    public MainFrame() {
        setTitle("Sistema do Mercadinho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public void trocarTela(JPanel novaTela) {
        // Salva a última tela antes de trocar
        // MUDANÇA 2: Verificamos se existe algo e salvamos como Component genérico
        if (getContentPane().getComponentCount() > 0) {
            ultimaTela = getContentPane().getComponent(0);
        }

        // Troca a tela
        setContentPane(novaTela);
        revalidate();
        repaint();
    }

    public void voltarTela() {
        if (ultimaTela != null) {
            // MUDANÇA 3: setContentPane espera um Container,
            // mas como Component é genérico, precisamos garantir que é válido.
            // O jeito mais seguro para voltar é assim:

            if (ultimaTela instanceof JPanel) {
                setContentPane((JPanel) ultimaTela);
            } else {
                // Se for um JLabel ou outra coisa, limpamos o painel atual e adicionamos ele
                getContentPane().removeAll();
                getContentPane().add(ultimaTela);
            }

            revalidate();
            repaint();
        }
    }
}