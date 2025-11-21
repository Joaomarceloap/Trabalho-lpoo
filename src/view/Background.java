package view;

import java.awt.*;
import javax.swing.*;

public class Background extends JPanel {

    private Image background;

    public Background(String imgPath) {
        background = new ImageIcon(imgPath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Desenha a imagem
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        //Overlay
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0, 0, 0, 100));     //a = intensidade
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
