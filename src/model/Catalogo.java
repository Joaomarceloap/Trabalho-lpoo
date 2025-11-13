package model;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private int idCatalogo;
    private List<Produto> listaDeProdutos;

    public Catalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
        this.listaDeProdutos = new ArrayList<>();
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public void adicionarProduto(Produto p) {
        if (!this.listaDeProdutos.contains(p)) { // Evita que tenha mais de um produto igual na lista por causa do .equals()
            this.listaDeProdutos.add(p);
            System.out.println("Produto " + p.getNome() + " adicionado ao catálogo.");
        }
    }
    public void removerProduto(Produto p) {
        boolean removido = this.listaDeProdutos.remove(p);
        if (removido) {
            System.out.println("Produto " + p.getNome() + " removido.");
        } else {
            System.out.println("Produto " + p.getNome() + " não encontrado no catálogo.");
        }
    }

    public Produto buscarProdutoPorCodigo(String codigoDeBarras) {
        for (Produto p : this.listaDeProdutos) {
            if (p.getCodigoDeBarras().equals(codigoDeBarras)) {
                return p;
            }
        }
        return null; // Se nao encontrar retorna null
    }
    public List<Produto> listarTodosProdutos() {
        return new ArrayList<>(this.listaDeProdutos);
    }
}