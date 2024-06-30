package software.ulpgc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image actualImage;
    private BufferedImage buffer;

    @Override
    public void show(Image image) {
        this.actualImage = image;
        buffer = loadImage(image.name());

        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int x = (this.getWidth() - buffer.getWidth()) / 2;
        int y = (this.getHeight() - buffer.getHeight()) / 2;
        g.drawImage(buffer, x, y, null);
    }

    @Override
    public Image image() {
        return actualImage;
    }

    private BufferedImage loadImage(String name){
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
