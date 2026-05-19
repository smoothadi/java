class Shape {
    public int area() {
        return 0;
    }
}

class Square extends Shape {
    private int side;

    Square(int side) { 
        this.side = side;
    }

    public int area() {
        return side * side;
    }
}

class Rectangle extends Shape {
    private int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return length * width;
    }
}

class AreaCalculator {
    class AreaDisplay {
        void show(Shape shape) {
            System.out.print("Area of " + (shape instanceof Square ? "Square: " : "Rectangle: "));
        }
    }

    class AreaCalculatorInner {
        int calculate(Shape shape) {
            return shape.area();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();
        AreaCalculator.AreaDisplay display = calc.new AreaDisplay();
        AreaCalculator.AreaCalculatorInner calculator = calc.new AreaCalculatorInner();
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(10, 4);
        display.show(square);
        System.out.println(calculator.calculate(square));
        display.show(rectangle);
        System.out.println(calculator.calculate(rectangle));
    }
}