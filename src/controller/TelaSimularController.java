package controller;

import java.util.List;
import model.Cliente;
import model.DAO.ClienteDAO;
import model.DAO.ProdutoDAO;
import model.Produto;
import view.MainFrame;
import view.TelaSimular;

public class TelaSimularController {

    private TelaSimular view;
    private MainFrame frame;
    private ClienteDAO clienteDAO;
    private ProdutoDAO produtoDAO;

    private Cliente clienteSelecionado;
    private Produto produtoSelecionado;

    public TelaSimularController(
            TelaSimular view,
            MainFrame frame,
            ClienteDAO clienteDAO,
            ProdutoDAO produtoDAO
    ) {
        this.view = view;
        this.frame = frame;
        this.clienteDAO = clienteDAO;
        this.produtoDAO = produtoDAO;

        carregarClientes();
        carregarProdutos();
        configurarEventos();
    }

    private void carregarClientes() {
        List<Cliente> clientes = clienteDAO.getAll();

        for (Cliente c : clientes) {
            view.getComboClientes().addItem(c.getNome() + " (ID: " + c.getNumeroFidelidade() + ")");
        }
    }

    private void carregarProdutos() {
        List<Produto> produtos = produtoDAO.getAll();

        for (Produto p : produtos) {
            view.getComboProdutos().addItem(p.getNome() + " (ID: " + p.getId() + ")");
        }
    }

    private void configurarEventos() {

        // Seleção de cliente
        view.getComboClientes().addActionListener(e -> {
            int index = view.getComboClientes().getSelectedIndex();
            if (index >= 0) {
                clienteSelecionado = clienteDAO.getAll().get(index);
            }
        });

        // Seleção de produto
        view.getComboProdutos().addActionListener(e -> {
            int index = view.getComboProdutos().getSelectedIndex();
            if (index >= 0) {
                produtoSelecionado = produtoDAO.getAll().get(index);
            }
        });

        // SIMULAR VENDA
        view.getBtnSimular().addActionListener(e -> {

            if (clienteSelecionado == null || produtoSelecionado == null) {
                view.exibirMensagem("Selecione um cliente e um produto.");
                return;
            }

            try {
                int qtd = Integer.parseInt(view.getCampoQuantidade().getText());

                if (!produtoSelecionado.estaDisponivel(qtd)) {
                    view.exibirMensagem("Estoque insuficiente!");
                    return;
                }

                double total = qtd * produtoSelecionado.getPreco();

                view.exibirMensagem(
                        "Cliente: " + clienteSelecionado.getNome() +
                        "\nProduto: " + produtoSelecionado.getNome() +
                        "\nQuantidade: " + qtd +
                        "\nTotal: R$ " + total
                );

            } catch (Exception ex) {
                view.exibirMensagem("Quantidade inválida.");
            }
        });

        // CONFIRMAR VENDA
        view.getBtnConfirmar().addActionListener(e -> {

            if (clienteSelecionado == null || produtoSelecionado == null) {
                view.exibirMensagem("Selecione cliente e produto antes de confirmar.");
                return;
            }

            try {
                int qtd = Integer.parseInt(view.getCampoQuantidade().getText());

                if (!produtoSelecionado.estaDisponivel(qtd)) {
                    view.exibirMensagem("Estoque insuficiente!");
                    return;
                }

                // Atualizar estoque
                produtoDAO.vendaProduto(produtoSelecionado.getId(), qtd);

                // Calcular pontos (1 ponto por real gasto)
                int pontos = (int) (qtd * produtoSelecionado.getPreco());
                clienteDAO.updatePontos(pontos, clienteSelecionado.getNumeroFidelidade());

                view.exibirMensagem("Venda confirmada!\nPontos adicionados: " + pontos);

            } catch (Exception ex) {
                view.exibirMensagem("Erro ao confirmar venda.");
            }
        });

        // BOTÃO VOLTAR
        view.getBtnVoltar().addActionListener(e -> frame.voltarTela());
    }
}
