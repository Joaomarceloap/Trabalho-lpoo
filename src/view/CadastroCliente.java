package view;

import java.awt.*;
import javax.swing.*;

public class CadastroCliente extends JDialog {

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEndereco;
    private JTextField campoTelefone;

    private JButton btnSalvar;
    private JButton btnCancelar;

    public CadastroCliente(JFrame parent) {
        super(parent, "Novo Cliente", true);

        campoNome = new JTextField(20);
        campoCpf = new JTextField(20);
        campoEndereco = new JTextField(20);
        campoTelefone = new JTextField(20);

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10)); // CORRIGIDO

        form.add(new JLabel("Nome:"));
        form.add(campoNome);

        form.add(new JLabel("CPF:"));
        form.add(campoCpf);

        form.add(new JLabel("Endereço:"));
        form.add(campoEndereco);

        form.add(new JLabel("Telefone:"));
        form.add(campoTelefone);

        form.add(new JLabel("")); // espaçamento
        form.add(new JLabel("")); // espaçamento

        form.add(btnCancelar);
        form.add(btnSalvar);

        add(form);
        pack();
        setLocationRelativeTo(parent);
    }

    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public String getNome() { return campoNome.getText(); }
    public String getCpf() { return campoCpf.getText(); }
    public String getEndereco() { return campoEndereco.getText(); }
    public String getTelefone() { return campoTelefone.getText(); }
}
