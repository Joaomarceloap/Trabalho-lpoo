import controller.MenuController;
import java.sql.Connection;
import java.sql.SQLException;
import model.DAO.ClienteDAO;
import model.DAO.DBconfig;
import model.DAO.ProdutoDAO;
import view.MainFrame;
import view.Menu;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            try {
                // Abre conexão permanente para o sistema
                Connection conexao = DBconfig.getConnection();
                System.out.println("Conectado ao banco: " + conexao.isValid(5));

                // Criar DAOs 1 vez só
                ClienteDAO clienteDAO = new ClienteDAO(conexao);
                ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

                // Criar tela principal
                MainFrame frame = new MainFrame();
                Menu menu = new Menu();

                // Controller principal (agora recebe conexão)
                new MenuController(menu, frame, conexao);

                // Exibir menu inicial
                frame.trocarTela(menu);
                frame.setVisible(true);

            } catch (SQLException e) {
                System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            }
        });
    }
}
