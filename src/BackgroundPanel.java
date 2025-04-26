import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;
    private static final long serialVersionUID = 1L;

    public BackgroundPanel(String resourcePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(resourcePath));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
