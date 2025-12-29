public class Day9 {
    public static void main(String[] args) {
        // 🔹 Upcasting
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5);          // Circle → Shape
        shapes[1] = new Rectangle(4, 6);    // Rectangle → Shape
        shapes[2] = new Triangle(3, 8);     // Triangle → Shape

        for (Shape shape : shapes) {
            shape.display();
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("--------------------");
        }
    }
}
abstract class Shape {

    public abstract double calculateArea();

    public void display() {
        System.out.println("Calculating area...");
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

