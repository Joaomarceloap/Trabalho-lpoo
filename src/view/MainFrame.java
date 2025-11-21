package view;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel ultimaTela;

    public MainFrame() {
    
        setTitle("Sistema do Mercadinho");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);   //Tamanho medio        //Mudar se necessario
        setLocationRelativeTo(null);    //Centraliza na tela
    }

    public void trocarTela(JPanel novaTela) {
        //Salva última tela
        if(this.getContentPane().getComponentCount() > 0) {
            ultimaTela = (JPanel) this.getContentPane().getComponent(0);
        }

        setContentPane(novaTela);       //Recebe o conteudo da tela nova
        revalidate();                   //Reorganiza os elementos
        repaint();                      //Redesenha a tela
    }

    public void voltarTela() {
        if (ultimaTela != null) {
            trocarTela(ultimaTela);
        }
    }
}
