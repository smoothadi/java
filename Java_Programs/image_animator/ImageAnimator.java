import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ImageAnimator extends JFrame {
    private JLabel imageLabel;
    private int index = 0;
    private String[] imagePaths;
    private int[] intervals;
    private ImageIcon[] images;

    public ImageAnimator(String[] imagePaths, int[] intervals) {
        this.imagePaths = imagePaths;
        this.intervals = intervals;
        images = new ImageIcon[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            images[i] = new ImageIcon(imagePaths[i]);
        }
        setTitle("Image Animator");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(imageLabel);
        setLocationRelativeTo(null);
    }

    public void startAnimation() {
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < imagePaths.length; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(intervals[i]);
                        updateImage(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public synchronized void updateImage(int index) {
        this.index = index;
        imageLabel.setIcon(images[index]);
    }

    public static void main(String[] args) {
        String[] imagePaths = { "./hero-1.jpg", "./hero-2.jpg", "./hero-3.jpg" };
        int[] intervals = { 2, 4, 1 };
        ImageAnimator animator = new ImageAnimator(imagePaths, intervals);
        animator.setVisible(true);
        animator.startAnimation();
    }
}