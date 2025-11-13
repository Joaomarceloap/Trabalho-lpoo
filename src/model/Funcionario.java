package model;
import java.time.LocalDate;

public abstract class Funcionario extends Pessoa{
    private String matricula;
    private double salario;
    private LocalDate dataAdmissao;

    public Funcionario(String nome, String cpf, String endereco, String telefone, String matricula, double salario, LocalDate dataAdmissao) {
        super(nome, cpf, endereco, telefone);
        this.matricula = matricula;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double calcularPagamento() {
        return this.salario;// Não pensei em uma lógica para calcular o sálario, qualquer coisa mudamos
    }

    public abstract void trabalhar();

}