package model;
import java.time.LocalDate;

public class Repositor extends Funcionario{
    private String setorResponsavel;

    public Repositor(String nome, String cpf, String endereco, String telefone, String matricula, double salario,LocalDate dataAdmissao, String setorResponsavel) {
        super(nome, cpf, endereco, telefone, matricula, salario, dataAdmissao);
        this.setorResponsavel = setorResponsavel;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    @Override
    public void trabalhar() {
        System.out.println("Repositor " + getNome() + " trabalhando no setor " + this.setorResponsavel);
    }

    public void reporEstoque(Produto produto, int quantidade) {
        System.out.println("Repondo " + quantidade + "x " + produto.getNome() + " na prateleira.");
        produto.adicionarEstoque(quantidade);
    }

    public void verificarValidade(Produto produto) {
        System.out.println("Verificando validade de: " + produto.getNome() + " no setor " + setorResponsavel);

        LocalDate dataValidade = produto.getDataValidade();
        LocalDate hoje = LocalDate.now(); // Pega a data atual
        if (dataValidade == null) {
            System.out.println("-> OK: Produto não perecível (sem data de validade).");
            return;
        }
        if (dataValidade.isBefore(hoje)) {
            System.out.println("-> ALERTA VENCIDO! Produto venceu em " + dataValidade + ". RETIRAR IMEDIATAMENTE!");
        } else if (dataValidade.isEqual(hoje)) {
            System.out.println("-> ATENÇÃO: Produto vence HOJE (" + dataValidade + "). Marcar para promoção/retirada.");
        } else {
            System.out.println("-> OK: Produto dentro da validade (vence em " + dataValidade + ").");
        }
    }



}