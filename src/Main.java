import model.DAO.DBconfig;
import model.DAO.PessoaDAO;
import model.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        try(Connection conexao = DBconfig.getConnection()){
            System.out.println("Conectado ao banco de dados " + conexao.isValid(5));

            PessoaDAO pessoaDAO = new PessoaDAO(conexao);

            Pessoa pessoa = pessoaDAO.getByCpf("11111111111");
            System.out.println(pessoa.toString());

        } catch(SQLException e){
            System.out.println("Erro ao conectar ao banco de dados " + e);
        }


    }
}