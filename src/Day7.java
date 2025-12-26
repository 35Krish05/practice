public class Day7 {
    public static void main(String[] args) {
                Employee emp = new Employee(101, "Amit Sharma", 30000);

                emp.display();

                System.out.println("\nSalary without bonus: ₹" +
                        emp.calculateSalary());

                System.out.println("Salary with fixed bonus: ₹" +
                        emp.calculateSalary(5000));

    }
}
class Employee {

    // 🔒 Encapsulated fields
    private int empId;
    private String name;
    private double basicSalary;

    // 🧱 Constructor
    public Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // 📌 Getter methods
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // 💰 Salary calculation (NO bonus)
    public double calculateSalary() {
        return basicSalary;
    }

    // 💰 Salary calculation (FIXED bonus)
    public double calculateSalary(double bonus) {
        return basicSalary + bonus;
    }
    // 🖨 Display employee details
    public void display() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: ₹" + basicSalary);
    }
}
