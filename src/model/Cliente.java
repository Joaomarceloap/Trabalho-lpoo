package model;

public class Cliente extends Pessoa {

    private int numeroFidelidade;   // ID da tabela cliente (FK do CPF em pessoa)
    private int pontosFidelidade;

    public Cliente(String nome, String cpf, String endereco, String telefone,
                   int numeroFidelidade, int pontosFidelidade) {

        super(nome, cpf, endereco, telefone);
        this.numeroFidelidade = numeroFidelidade;
        this.pontosFidelidade = pontosFidelidade;
    }

    public int getNumeroFidelidade() { return numeroFidelidade; }
    public void setNumeroFidelidade(int numeroFidelidade) { this.numeroFidelidade = numeroFidelidade; }

    public int getPontosFidelidade() { return pontosFidelidade; }
    public void setPontosFidelidade(int pontosFidelidade) { this.pontosFidelidade = pontosFidelidade; }

    public void adicionarPontos(int pontos) {
        if (pontos > 0) {
            this.pontosFidelidade += pontos;
            System.out.println(pontos + " pontos adicionados. Saldo atual: " + this.pontosFidelidade);
        }
    }

    public void resgatarPontos(int pontos) {
        if (pontos <= 0) {
            System.out.println("Valor de resgate inválido.");
        } else if (pontos <= this.pontosFidelidade) {
            this.pontosFidelidade -= pontos;
            System.out.println(pontos + " pontos resgatados. Saldo restante: " + this.pontosFidelidade);
        } else {
            System.out.println("Saldo de pontos insuficiente para resgate.");
        }
    }
}
