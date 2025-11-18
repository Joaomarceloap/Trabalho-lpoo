import java.awt.GridLayout;
import javax.swing.*;

public class Menu extends JPanel{
    //Atributos
    private JButton btnSimularDia;
    private JButton btnProdutos;
    private JButton btnFuncionarios;
    private JButton btnClientes;
    private JButton btnSair;

    //Construtor
    public Menu(){
        btnSimularDia = new JButton("Simular dia");
        btnProdutos = new JButton("Gerenciar produtos");
        btnFuncionarios = new JButton("Gerenciar funcionarios");
        btnClientes = new JButton("Gerenciar clientes");
        btnSair = new JButton("Sair");

        //Grid para aempilhar botôes
        setLayout(new GridLayout(5,1));
    }

    //Getters
    public JButton getBtnSimularDia(){ return btnSimularDia; }
    public JButton getBtnProdutos(){ return btnProdutos; }
    public JButton getBtnFuncionarios(){ return btnFuncionarios; }
    public JButton getBtnClientes(){ return btnClientes; }
    public JButton getBtnSair(){ return btnSair; }
}
