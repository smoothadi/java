import java.awt.*;
import java.awt.event.*;

public class MouseClick {
    Label lbl = new Label("Welcome");

    public static void main(String[] args) {
        new MouseClick();
    }

    public MouseClick() {
        Frame f = new Frame("Checking the Mouse Click");

        Button button = new Button("Click me");

        // Mouse Listener
        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                lbl.setText(
                    lbl.getText().equals("Welcome")
                    ? "You have clicked the button"
                    : "Welcome"
                );
            }
        });

        f.add(button, BorderLayout.NORTH);
        f.add(lbl, BorderLayout.CENTER);

        // Window Closing Event
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Important lines
        f.setSize(400, 200);
        f.setVisible(true);
    }
}