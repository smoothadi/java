import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    JFrame f = new JFrame("Calculator");
    JTextField t = new JTextField();
    double n1, n2;
    String op;

    SimpleCalculator() {
        t.setFont(new Font("Arial", Font.BOLD, 30));
        t.setEditable(false);

        JPanel p = new JPanel(new GridLayout(4,4));
        String[] b = {"7","8","9","/","4","5","6","*","1","2","3","-","C","0","=","+"};

        for(String s : b){
            JButton bt = new JButton(s);
            bt.setFont(new Font("Arial", Font.BOLD, 20));
            bt.addActionListener(e -> click(s));
            p.add(bt);
        }

        f.add(t,BorderLayout.NORTH);
        f.add(p,BorderLayout.CENTER);
        f.setSize(350,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    void click(String c){
        if(c.equals("C")) t.setText("");
        else if(c.equals("=")){
            n2 = Double.parseDouble(t.getText());
            t.setText(""+calc());
        }
        else if("+-*/".contains(c)){
            n1 = Double.parseDouble(t.getText());
            op = c; t.setText("");
        }
        else t.setText(t.getText()+c);
    }

    double calc(){
        switch(op){
            case "+": return n1+n2;
            case "-": return n1-n2;
            case "*": return n1*n2;
            case "/": return n2==0?0:n1/n2;
        }
        return 0;
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}