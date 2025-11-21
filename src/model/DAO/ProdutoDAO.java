package model.DAO;

import model.Produto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        if(conexao == null) {
            System.out.println("conexao nao deve ser null");
        }
        this.conexao = conexao;
    }

    public void createProduto(Produto produto) {
        String sql = "INSERT INTO produto VALUES (?, ?, ?, ?)";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQtdEstoque());

            stmt.executeUpdate();
            System.out.println(produto.getNome() + " Cadastrado com sucesso");
        } catch(SQLException e){
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public Produto getProduto(int id){
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    produto = new Produto(
                            id,
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getInt("quantidade")
                    );

                } else {
                    System.out.println("Produto inexistente");
                }
            }
        } catch(SQLException e){
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return produto;
    }

    public void vendaProduto(int id, int qnt) { //para usar e so ter um produtoDAO com o id e inserir -> produtoDAO.vendaProduto(1, 10);
        String sql = "UPDATE produto SET quantidade = quantidade - ? WHERE id = ?";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, qnt);
            stmt.setInt(2,id);


            stmt.executeUpdate();
            System.out.println("Estoque atualizado");
        }catch(SQLException e){
            System.out.println("Erro ao diminuir estoque do produto: " + e.getMessage());
        }
    }

    public void addEstoque (int id, int qnt){
        String sql = "UPDATE produto SET quantidade = quantidade + ? WHERE id = ?";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1,qnt);
            stmt.setInt(2,id);

            stmt.executeUpdate();
            System.out.println("Estoque atualizado");
        } catch(SQLException e){
            System.out.println("Erro ao adicionar estoque do produto: " + e.getMessage());
        }
    }

    public void deleteProduto(Produto produto) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
            stmt.setInt(1, produto.getId());

            int cont = stmt.executeUpdate();
            if(cont > 0) {
                System.out.println(produto.getNome() + " foi deletado");
            } else {
                System.out.println(produto.getNome() + " nao foi encontrado");
            }
        } catch(SQLException e){
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    public List<Produto> getAll(){
        String sql = "SELECT * FROM produto";
         List<Produto> produtos = new ArrayList<>();

         try(PreparedStatement stmt = this.conexao.prepareStatement(sql)){
             ResultSet rs = stmt.executeQuery();
             while (rs.next()){
                 Produto p = new Produto(
                 rs.getInt("id"),
                 rs.getString("nome"),
                 rs.getDouble("preco"),
                 rs.getInt("qtdEstoque")
                );
                 produtos.add(p);
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }

         return produtos;
    }
}