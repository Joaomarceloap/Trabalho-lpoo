package model.DAO;

import model.Mercadinho;

import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MercadinhoDAO {
    private Connection conexao;

    public MercadinhoDAO(Connection conexao) {
        if(conexao == null){
            System.out.println("erro conexao null");
        } else{
            this.conexao = conexao;
        }
    }
    public void create(Mercadinho mercadinho){
        String sql = "INSERT INTO mercadinho VALUES (?,?,?)";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, mercadinho.getId());
            stmt.setInt(2, mercadinho.getVendas());
            stmt.setDouble(3, mercadinho.getReceitaTotal());

            stmt.execute();
            System.out.println("Mercadinho adicionado com sucesso");
        } catch (SQLException e){
            System.out.println("Erro ao inserir mercadinho: " + e.getMessage());
        }
    }

    public Mercadinho getMercadinho(int id) {
        String sql = "SELECT * FROM mercadinho WHERE id = ?";
        Mercadinho m = null;

        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    m.setId(id);
                    m.setVendas(rs.getInt("vendas"));
                    m.setReceitaTotal(rs.getDouble("receita_total"));

                    System.out.println("id: " + id + " Numero de vendas: "+m.getVendas()+ " Receita: "+m.getReceitaTotal());
                }
            }
        } catch(SQLException e){
            System.out.println("Erro ao recuperar mercadinho: " + e.getMessage());
        }
        return m;
    }

    public void regVenda(int id, int id_produto){
        String sql = "UPDATE INTO mercadinho SET vendas = vendas+? receita = receita_total +? WHERE id = ?";
    }
}
