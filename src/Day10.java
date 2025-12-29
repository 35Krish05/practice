public class Day10 {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota"); // upcasting
        Vehicle v2 = new Bike("Yamaha");

        v1.start();
        v1.fuelType();

        v2.start();
        v2.fuelType();

        Movable m1 = new Car("Honda");
        m1.move();
        m1.speedInfo();

        Movable.generalInfo();
    }
}
abstract class Vehicle {

    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void start();

    public void fuelType() {
        System.out.println("Fuel required");
    }
}
interface Movable {

    int MAX_SPEED = 120; // public static final by default

    void move();

    default void speedInfo() {
        System.out.println("Max speed is " + MAX_SPEED + " km/h");
    }

    static void generalInfo() {
        System.out.println("Vehicles can move from one place to another");
    }
}
class Car extends Vehicle implements Movable {

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(brand + " car starts with key");
    }

    @Override
    public void move() {
        System.out.println("Car is moving on road");
    }
}
class Bike extends Vehicle implements Movable {

    public Bike(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(brand + " bike starts with self-start");
    }

    @Override
    public void move() {
        System.out.println("Bike is moving swiftly");
    }
}

