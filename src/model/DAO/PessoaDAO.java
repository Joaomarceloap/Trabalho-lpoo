package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;

public class PessoaDAO {
    private Connection conexao;

    public PessoaDAO(Connection conexao) {
        if (conexao == null) {
            System.out.println("A conexão não pode ser nula!");
        }
        this.conexao = conexao;
    }

    public void create(Pessoa pessoa){
        String sql = "INSERT INTO pessoa (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, pessoa.getEndereco());
            stmt.setString(4, pessoa.getTelefone());

            stmt.executeUpdate();
            System.out.println("Pessoa cadastrada com sucesso!");

        } catch (SQLException e){
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    public Pessoa getByCpf(String cpf){
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        Pessoa pessoa = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    pessoa = new Pessoa(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                    );
                }
            }

        } catch (SQLException e){
            System.out.println("Erro ao buscar pessoa: " + e.getMessage());
        }

        return pessoa;
    }
}
