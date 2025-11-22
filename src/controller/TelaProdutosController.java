package controller;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import model.DAO.ProdutoDAO;
import model.Produto;
import view.MainFrame;
import view.TelaProdutos;

public class TelaProdutosController {

    private TelaProdutos view;
    private MainFrame frame;
    private ProdutoDAO produtoDAO;

    public TelaProdutosController(TelaProdutos view, MainFrame frame, ProdutoDAO produtoDAO) {
        this.view = view;
        this.frame = frame;
        this.produtoDAO = produtoDAO;

        configurarEventos();
    }

    private void configurarEventos() {

        // ADICIONAR PRODUTO
        view.getBtnInserirProduto().addActionListener(e -> {
            try {
                if (view.getCampoId().getText().isEmpty()
                        || view.getCampoNome().getText().isEmpty()
                        || view.getCampoPreco().getText().isEmpty()
                        || view.getCampoQtd().getText().isEmpty()) {

                    view.exibirMensagem("Preencha todos os campos.");
                    return;
                }

                int id = Integer.parseInt(view.getCampoId().getText());
                String nome = view.getCampoNome().getText();
                double preco = Double.parseDouble(view.getCampoPreco().getText());
                int qtd = Integer.parseInt(view.getCampoQtd().getText());

                Produto novo = new Produto(id, nome, preco, qtd);
                produtoDAO.createProduto(novo);

                view.exibirMensagem("Produto inserido com sucesso!");

            } catch (Exception ex) {
                view.exibirMensagem("Erro ao inserir produto: " + ex.getMessage());
            }
        });
        // ORDENAR POR NOME
        view.getBtnOrdenarNome().addActionListener(e -> {

            Set<Produto> ordenado = new TreeSet<>(
                    Comparator.comparing(Produto::getNome)
                            .thenComparing(Produto::getId)
            );

            ordenado.addAll(produtoDAO.getAll());
            mostrarOrdenados(ordenado);
        });

        // ORDENAR POR ESTOQUE
        view.getBtnOrdenarEstoque().addActionListener(e -> {

            Set<Produto> ordenado = new TreeSet<>(
                    Comparator.comparing(Produto::getQtdEstoque)
                            .thenComparing(Produto::getNome)
                            .thenComparing(Produto::getId)
            );

            ordenado.addAll(produtoDAO.getAll());
            mostrarOrdenados(ordenado);
        });

        // ORDENAR POR PREÇO
        view.getBtnOrdenarPreco().addActionListener(e -> {

            Set<Produto> ordenado = new TreeSet<>(
                    Comparator.comparing(Produto::getPreco)
                            .thenComparing(Produto::getNome)
                            .thenComparing(Produto::getId)
            );

            ordenado.addAll(produtoDAO.getAll());
            mostrarOrdenados(ordenado);
        });

        // VOLTAR
        view.getBtnVoltar().addActionListener(e -> frame.voltarTela());
    }

    private void mostrarOrdenados(Set<Produto> produtos) {
        if (produtos.isEmpty()) {
            view.exibirMensagem("Nenhum produto encontrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Produto p : produtos) {
            sb.append(String.format("%d - %s - R$ %.2f - Estoque: %d\n",
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getQtdEstoque()));

        }

        view.exibirMensagem(sb.toString());
    }
}
