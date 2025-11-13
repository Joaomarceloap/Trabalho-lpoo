package model;
import java.time.LocalDate;

public class Atendente extends Funcionario{
    private int numeroDoCaixa;
    private double totalVendasDia;

    public Atendente(String nome, String cpf, String endereco, String telefone, String matricula, double salario, LocalDate dataAdmissao, int numeroDoCaixa) {
        super(nome, cpf, endereco, telefone, matricula, salario, dataAdmissao);
        this.numeroDoCaixa = numeroDoCaixa;
        this.totalVendasDia = 0.0;
    }

    public int getNumeroDoCaixa() {
        return numeroDoCaixa;
    }

    public void setNumeroDoCaixa(int numeroDoCaixa) {
        this.numeroDoCaixa = numeroDoCaixa;
    }

    public double getTotalVendasDia() {
        return totalVendasDia;
    }

    public void setTotalVendasDia(double totalVendasDia) {
        this.totalVendasDia = totalVendasDia;
    }

    @Override
    public void trabalhar() {
        System.out.println("Atendente " + getNome() + " operando o caixa " + this.numeroDoCaixa);
    }

    public void abrirCaixa() {
        this.totalVendasDia = 0.0;
        System.out.println("Caixa " + numeroDoCaixa + " aberto. Total de vendas zerado.");
    }

    public void fecharCaixa() {
        System.out.println("Caixa " + numeroDoCaixa + " fechado.");
        System.out.println("TOTAL DE VENDAS DA SESSÃO: R$ " + String.format("%.2f", this.totalVendasDia));
    }

    public void registrarVenda(Produto produto, int quantidade) {
        if (produto.estaDisponivel(quantidade)) {
            double valorDaVenda = produto.getPreco() * quantidade;
            this.totalVendasDia += valorDaVenda;
            produto.removerEstoque(quantidade);
            System.out.println("Venda registrada: " + quantidade + "x " + produto.getNome() + " - Valor: R$ " + String.format("%.2f", valorDaVenda));
        } else {
            System.out.println("VENDA NÃO REALIZADA: Estoque insuficiente de " + produto.getNome());
        }
    }



}