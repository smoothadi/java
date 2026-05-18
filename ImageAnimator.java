import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ImageAnimator extends JFrame {
    JLabel label = new JLabel("", JLabel.CENTER);
    ImageIcon[] imgs;

    public ImageAnimator(String[] paths, int[] time) {
        imgs = new ImageIcon[paths.length];
        for (int i = 0; i < paths.length; i++)
            imgs[i] = new ImageIcon(paths[i]);

        add(label);
        setTitle("Image Animator");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        new Thread(() -> {
            while (true) {
                for (int i = 0; i < imgs.length; i++) {
                    try {
                        label.setIcon(imgs[i]);
                        TimeUnit.SECONDS.sleep(time[i]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new ImageAnimator(
            new String[]{
                "Z:\\Kishore\\Animator\\Virat1.JPG",
                "Z:\\Kishore\\Animator\\Virat2.JPG",
                "Z:\\Kishore\\Animator\\Virat3.JPG"
            },
            new int[]{2, 4, 1}
        ).setVisible(true);
    }
}
