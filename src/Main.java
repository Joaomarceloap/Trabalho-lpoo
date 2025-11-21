import model.DAO.DBconfig;
import model.DAO.MercadinhoDAO;
import model.DAO.PessoaDAO;
import model.DAO.ProdutoDAO;
import model.Mercadinho;
import model.Pessoa;
import model.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        try(Connection conexao = DBconfig.getConnection()){
            System.out.println("Conectado ao banco de dados " + conexao.isValid(5));

            MercadinhoDAO mercadinhoDAO = new MercadinhoDAO(conexao);
            Mercadinho mercadinho = new Mercadinho(1, 100, 1500.20);
            mercadinhoDAO.create(mercadinho);

        } catch(SQLException e){
            System.out.println("Erro ao conectar ao banco de dados " + e);
        }


    }
}