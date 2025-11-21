package view;

import java.util.Stack;
import javax.swing.*;
import java.awt.Component; // Import necessário

public class MainFrame extends JFrame {

<<<<<<< HEAD
    // MUDANÇA 1: Agora é 'Component', aceita Painel, Label, Botão, etc.
    private Component ultimaTela;

    public MainFrame() {
=======
    private JPanel telaBase; // menu inicial
    private Stack<JPanel> telasHistorico = new Stack<>();

    public MainFrame(JPanel menuInicial) {
        this.telaBase = menuInicial;

>>>>>>> fb852e140e2d34a6f677cef26c84c19a681e1f07
        setTitle("Sistema do Mercadinho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
<<<<<<< HEAD
    }

    public void trocarTela(JPanel novaTela) {
        // Salva a última tela antes de trocar
        // MUDANÇA 2: Verificamos se existe algo e salvamos como Component genérico
        if (getContentPane().getComponentCount() > 0) {
            ultimaTela = getContentPane().getComponent(0);
        }

        // Troca a tela
=======

        // Mostra o menu inicial
        setContentPane(telaBase);
    }

    public void trocarTela(JPanel novaTela) {
        // Salva tela atual na pilha de histórico
        JPanel telaAtual = (JPanel) getContentPane();
        telasHistorico.push(telaAtual);

        // Troca para a nova tela
>>>>>>> fb852e140e2d34a6f677cef26c84c19a681e1f07
        setContentPane(novaTela);
        revalidate();
        repaint();
    }

    public void voltarTela() {
<<<<<<< HEAD
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

=======
        if (!telasHistorico.isEmpty()) {
            JPanel telaAnterior = telasHistorico.pop();
            setContentPane(telaAnterior);
            revalidate();
            repaint();
        } else {
            // Se não houver histórico, volta para o menu
            setContentPane(telaBase);
>>>>>>> fb852e140e2d34a6f677cef26c84c19a681e1f07
            revalidate();
            repaint();
        }
    }
}
