import model.DAO.DBconfig;
import view.MainFrame;
import view.Menu;
import controller.MenuController;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        // Iniciar conexão (opcional, apenas teste)
        try (Connection conexao = DBconfig.getConnection()) {
            System.out.println("Conectado ao banco de dados: " + conexao.isValid(5));
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }

        // INICIAR INTERFACE GRÁFICA
        javax.swing.SwingUtilities.invokeLater(() -> {

            MainFrame frame = new MainFrame();
            Menu menu = new Menu();

            // Controller que conecta botões do menu → troca de telas
            new MenuController(menu, frame);

            frame.trocarTela(menu);
            frame.setVisible(true);
        });
    }
}
