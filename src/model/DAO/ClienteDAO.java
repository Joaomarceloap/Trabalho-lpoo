package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        if (conexao == null) {
            throw new IllegalArgumentException("A conexão não pode ser nula.");
        }
        this.conexao = conexao;
    }

    public void create(Cliente c) {
        String sqlPessoa = "INSERT INTO pessoa (cpf, nome, endereco, telefone) VALUES (?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO cliente (cpf, pontos) VALUES (?, ?)";

        try {
            // INSERE NA TABELA PESSOA
            PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa);
            stmtPessoa.setString(1, c.getCpf());
            stmtPessoa.setString(2, c.getNome());
            stmtPessoa.setString(3, c.getEndereco());
            stmtPessoa.setString(4, c.getTelefone());
            stmtPessoa.executeUpdate();

            // INSERE NA TABELA CLIENTE
            PreparedStatement stmtCliente = conexao.prepareStatement(sqlCliente);
            stmtCliente.setString(1, c.getCpf());
            stmtCliente.setInt(2, c.getPontosFidelidade());
            stmtCliente.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public Cliente get(int id) {
        String sql = """
            SELECT p.nome, p.cpf, p.endereco, p.telefone,
                   c.id_cliente, c.pontos
            FROM cliente c
            JOIN pessoa p ON c.cpf = p.cpf
            WHERE c.id_cliente = ?
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getInt("id_cliente"),
                    rs.getInt("pontos")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return null;
    }

    public void updatePontos(int qtd, int id) {
        String sql = "UPDATE cliente SET pontos = pontos + ? WHERE id_cliente = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, qtd);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Pontos adicionados com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pontos: " + e.getMessage());
        }
    }

    public void resgatarPontos(int id, int pontos) {
        String sql = "UPDATE cliente SET pontos = pontos - ? WHERE id_cliente = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, pontos);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Pontos resgatados com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao resgatar pontos: " + e.getMessage());
        }
    }

    public List<Cliente> getAll() {
        String sql = """
            SELECT p.nome, p.cpf, p.endereco, p.telefone,
                   c.id_cliente, c.pontos
            FROM cliente c
            JOIN pessoa p ON c.cpf = p.cpf
        """;

        List<Cliente> lista = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getInt("id_cliente"),
                    rs.getInt("pontos")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        }

        return lista;
    }
}
