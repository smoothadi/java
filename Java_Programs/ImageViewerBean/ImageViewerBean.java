import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageViewerBean {
    private BufferedImage image;

    public void loadImage(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayImage() {
        if (image != null) {
            JFrame frame = new JFrame("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0,
                            null);
                }
            });
            frame.setVisible(true);
        } else {
            System.out.println("No image loaded.");
        }
    }

    public static void main(String[] args) {
        ImageViewerBean viewer = new ImageViewerBean();
        viewer.loadImage("about.jpg");
        viewer.displayImage();
    }
}