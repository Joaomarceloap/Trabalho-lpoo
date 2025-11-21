package model;

public class Mercadinho {
    private int id;
    private int vendas;
    private double receitaTotal;

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}
    public void setReceitaTotal(double receitaTotal) {this.receitaTotal = receitaTotal;}
    public double getReceitaTotal() {return receitaTotal;}
    public void setVendas(int vendas) {this.vendas = vendas;}
    public int getVendas() {return vendas;}

    public Mercadinho(int id, int vendas, double receitaTotal) {
        this.id = id;
        this.vendas = vendas;
        this.receitaTotal = receitaTotal;
    }
    @Override
    public String toString() {
        return "Numero de vendas: " + getVendas() + " Receita total: " + getReceitaTotal();
    }

    public void regVenda(int qtd, double valor){
        this.vendas += qtd;
        this.receitaTotal += valor;
    }
}
