import javax.swing.*;
import java.awt.*;

public class ShapeDrawer extends JFrame {
    private Shape selectedShape = Shape.CIRCLE;
    private Color selectedColor = Color.ORANGE;

    public enum Shape {
        CIRCLE, 
        RECTANGLE, 
        OVAL, 
        TRIANGLE, 
        LINE, 
        POLYGON
    }

    public ShapeDrawer(int width, int height, int x, int y) {
        setTitle("Shape Drawer");
        setSize(width, height);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu shapeMenu = new JMenu("Shapes");
        menuBar.add(shapeMenu);

        JMenuItem circleItem = new JMenuItem("Circle");
        circleItem.addActionListener(e -> {
            selectedShape = Shape.CIRCLE;
            repaint();
        });
        shapeMenu.add(circleItem);

        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(e -> {
            selectedShape = Shape.RECTANGLE;
            repaint();
        });
        shapeMenu.add(rectangleItem);

        JMenuItem ovalItem = new JMenuItem("Oval");
        ovalItem.addActionListener(e -> {
            selectedShape = Shape.OVAL;
            repaint();
        });
        shapeMenu.add(ovalItem);

        JMenuItem triangleItem = new JMenuItem("Triangle");
        triangleItem.addActionListener(e -> {
            selectedShape = Shape.TRIANGLE;
            repaint();
        });
        shapeMenu.add(triangleItem);

        JMenuItem lineItem = new JMenuItem("Line");
        lineItem.addActionListener(e -> {
            selectedShape = Shape.LINE;
            repaint();
        });
        shapeMenu.add(lineItem);
        
        JMenuItem polygonItem = new JMenuItem("Polygon");
        polygonItem.addActionListener(e -> {
            selectedShape = Shape.POLYGON;
            repaint();
        });
        shapeMenu.add(polygonItem);

        JMenu colorMenu = new JMenu("Colors");
        menuBar.add(colorMenu);

        JMenuItem redItem = new JMenuItem("Red");
        redItem.addActionListener(e -> {
            selectedColor = Color.RED;
            repaint();
        });
        colorMenu.add(redItem);

        JMenuItem greenItem = new JMenuItem("Green");
        greenItem.addActionListener(e -> {
            selectedColor = Color.GREEN;
            repaint();
        });
        colorMenu.add(greenItem);

        JMenuItem blueItem = new JMenuItem("Blue");
        blueItem.addActionListener(e -> {
            selectedColor = Color.BLUE;
            repaint();
        });
        colorMenu.add(blueItem);

        add(new ShapePanel());
        setVisible(true);
    }

    private class ShapePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(selectedColor); // Set the color for drawing shapes
            switch (selectedShape) {
                case CIRCLE:
                    g.fillOval(100, 100, 100, 100); // Draw a circle
                    break;
                case RECTANGLE:
                    g.fillRect(100, 100, 150, 100); // Draw a rectangle
                    break;
                case OVAL:
                    g.fillOval(100, 100, 150, 100); // Draw an oval
                    break;
                case TRIANGLE:
                    int[] xPoints = { 100, 150, 200 };
                    int[] yPoints = { 200, 100, 200 };
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
                case LINE:
                    g.drawLine(100, 100, 200, 200);
                    break;
                case POLYGON:
                    int[] xPolygon = { 100, 150, 200, 250 };
                    int[] yPolygon = { 100, 50, 100, 150 };
                    g.fillPolygon(xPolygon, yPolygon, 4);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java ShapeDrawer <width> <height><x_position> <y_position>");
            System.exit(1);
        }
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        new ShapeDrawer(width, height, x, y);
    }
}