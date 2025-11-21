package model.DAO;

import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        if(conexao == null){
            System.out.println("A conexao nao pode ser feita");
        } else {
            this.conexao = conexao;
        }
    }

    public void create(Cliente c){
        String sql = "INSERT INTO clientes VALUES(?, ?, ?)";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, c.getNumeroFidelidade());
            stmt.setString(2, c.getCpf());
            stmt.setInt(3, c.getPontosFidelidade());

            stmt.executeUpdate();
            System.out.println("Cliente cadastrado");
        } catch(SQLException e){
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }
    public void get(int id){
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("id: " +  rs.getInt("id") + " Pontos: " + rs.getInt("pontos") + "cpf :" + rs.getString("cpf"));

            }
        } catch(SQLException e){
            System.out.println("Cliente nao encontrado " + e.getMessage());
        }
    }

    public void updatePontos(int qtd, int id){
        String sql = "UPDATE clientes SET pontos = pontos + ? WHERE id = ? ";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, qtd);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Pontos atualizados com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar pontos: " + e.getMessage());
        }
    }

    public void resgatarPontos(int id,  int pontos){
        String sql = "UPDATE clientes SET pontos = pontos - ? WHERE id = ? ";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, pontos);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Pontos atualizados com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pontos: " + e.getMessage());
        }
    }
}
