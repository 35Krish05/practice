public class Day8 {
    public static void main(String[] args) {
                Manager mgr = new Manager(
                        "Amit Sharma",
                        35,
                        101,
                        60000,
                        15000
                );
                System.out.println("\n--- Manager Details ---");
                mgr.displayInfo();
            }
        }

class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Employees extends Person {

    protected int empId;
    protected double salary;

    public Employees(String name, int age, int empId, double salary) {
        super(name, age); // constructor chaining
        this.empId = empId;
        this.salary = salary;
        System.out.println("Employee constructor called");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: ₹" + salary);
    }
}
class Manager extends Employees {

    private double bonus;

    public Manager(String name, int age, int empId, double salary, double bonus) {
        super(name, age, empId, salary); // chaining continues
        this.bonus = bonus;
        System.out.println("Manager constructor called");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: ₹" + bonus);
        System.out.println("Total Salary: ₹" + (salary + bonus));
    }
}

