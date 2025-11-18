import javax.swing.*;

public class TelaSimularDia extends JPanel{
    //Atributos
    private JButton btnSimular;
    private JButton btnResetarDias;

    //Constutor
    public TelaSimularDia(){
        btnSimular = new JButton("Simular");
        btnResetarDias = new JButton("Resetar dias");
    }

    //Getters
    public JButton getBtnSimular(){ return btnSimular; }
    public JButton getBtnResetarDias(){ return btnResetarDias; }
}
