package view;

import java.util.Stack;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel telaBase; // menu inicial
    private Stack<JPanel> telasHistorico = new Stack<>();

    public MainFrame(JPanel menuInicial) {
        this.telaBase = menuInicial;

        setTitle("Sistema do Mercadinho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Mostra o menu inicial
        setContentPane(telaBase);
    }

    public void trocarTela(JPanel novaTela) {
        // Salva tela atual na pilha de histórico
        JPanel telaAtual = (JPanel) getContentPane();
        telasHistorico.push(telaAtual);

        // Troca para a nova tela
        setContentPane(novaTela);
        revalidate();
        repaint();
    }

    public void voltarTela() {
        if (!telasHistorico.isEmpty()) {
            JPanel telaAnterior = telasHistorico.pop();
            setContentPane(telaAnterior);
            revalidate();
            repaint();
        } else {
            // Se não houver histórico, volta para o menu
            setContentPane(telaBase);
            revalidate();
            repaint();
        }
    }
}
