package model;

import java.time.LocalDate;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private String codigoDeBarras;
    private String nome;
    private double preco;
    private int qtdEstoque;
    private LocalDate dataValidade;

    public Produto(String codigoDeBarras, String nome, double preco, int qtdEstoque, LocalDate dataValidade) {
        this.codigoDeBarras = codigoDeBarras;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.dataValidade = dataValidade;
    }
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.qtdEstoque += quantidade;
            System.out.println("Estoque de " + nome + " atualizado: " + this.qtdEstoque);
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > 0 && estaDisponivel(quantidade)) {
            this.qtdEstoque -= quantidade;
            System.out.println(quantidade + "x " + nome + " removido(s) do estoque.");
        } else {
            System.out.println("Falha ao remover " + nome + ": estoque insuficiente ou quantidade inválida.");
        }
    }

    public boolean estaDisponivel(int quantidadeDesejada) {
        return this.qtdEstoque >= quantidadeDesejada;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return Objects.equals(codigoDeBarras, produto.codigoDeBarras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDeBarras);
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return this.nome.compareTo(outroProduto.nome);
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", estoque=" + qtdEstoque + ", validade=" + dataValidade + "]";
    }

}