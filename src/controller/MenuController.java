package controller;

import java.sql.Connection;
import model.DAO.ClienteDAO;
import model.DAO.ProdutoDAO;
import view.MainFrame;
import view.Menu;
import view.TelaClientes;
import view.TelaProdutos;
import view.TelaSimular;

public class MenuController {

    private Menu view;
    private MainFrame frame;
    private ClienteDAO clienteDAO;
    private ProdutoDAO produtoDAO;

    public MenuController(Menu view, MainFrame frame, Connection conexao) {
        this.view = view;
        this.frame = frame;

        // Instancia os DAOs UMA VEZ só
        this.clienteDAO = new ClienteDAO(conexao);
        this.produtoDAO = new ProdutoDAO(conexao);

        configurarEventos();
    }

    private void configurarEventos() {

        view.getbtnSimularVendas().addActionListener(e -> {
            TelaSimular tela = new TelaSimular();
            new TelaSimularController(tela, frame, clienteDAO, produtoDAO);
            frame.trocarTela(tela);
        });

        view.getBtnProdutos().addActionListener(e -> {
            TelaProdutos tela = new TelaProdutos();
            new TelaProdutosController(tela, frame, produtoDAO);
            frame.trocarTela(tela);
        });

        view.getBtnClientes().addActionListener(e -> {
            TelaClientes tela = new TelaClientes();
            new TelaClientesController(tela, frame, clienteDAO);
            frame.trocarTela(tela);
        });

        view.getBtnSair().addActionListener(e -> System.exit(0));
    }
}
