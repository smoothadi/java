import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField textField;
    private double num1, num2;
    private String operator;

    public SimpleCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(450, 600);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 36)); 
        textField.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(5, 4, 0, 0));
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "C", "0", "=", "+"};

        for (String label : buttons) {
            JButton button = new JButton(label); button.setFont(new
            Font("Arial", Font.PLAIN, 24));
            button.addActionListener(e ->
            buttonClicked(e.getActionCommand()));
            panel.add(button);
        }
        panel.getComponent(15).setPreferredSize(new Dimension(400,80));
        frame.setLayout(new BorderLayout()); frame.add(textField, BorderLayout.NORTH); 
        frame.add(panel, BorderLayout.CENTER); frame.setVisible(true);
    }
    private void buttonClicked(String command) {
        if ("C".equals(command))
            textField.setText("");
        else if ("=".equals(command)) {
            num2 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(calculate()));
        } else if ("+-*/".contains(command)) {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    private double calculate() { 
        switch(operator) {
            case "+": return num1 + num2; 
            case "-": return num1 - num2; 
            case "*": return num1 * num2;
            case "/": return num2 == 0 ? Double.NaN : num1 / num2; 
            default: return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}