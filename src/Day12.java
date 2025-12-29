import java.util.ArrayList;
import java.util.Scanner;

public class Day12 {
    static ArrayList<String> students = new ArrayList<>();
    static ArrayList<Integer> roll = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> marks = new ArrayList<>();
    static ArrayList<Integer> total = new ArrayList<>();
    static ArrayList<Integer> percentage = new ArrayList<>();
    static ArrayList<Character> grade = new ArrayList<>();

    public static void main(String[] args) {

        addStudent();
        calculateResult();

        while (true) {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT =====");
            System.out.println("1. Display All Students");
            System.out.println("2. Search Student by Roll No");
            System.out.println("3. Find Topper");
            System.out.println("4. Find Average Marks");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    searchByRoll();
                    break;
                case 3:
                    findTopper();
                    break;
                case 4:
                    findAverage();
                    break;
                case 5:
                    System.out.println("Program exited.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void addStudent() {
        while (true) {
            System.out.print("Enter student name (or type 'exit' to stop): ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            students.add(name);
            System.out.print("Roll No: ");
            int roll1 = sc.nextInt();
            roll.add(roll1);
            System.out.print("Enter Marks of 5 subject : ");
            ArrayList<Integer> subjectMarks = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                int marks1 = sc.nextInt();
                subjectMarks.add(marks1);
            }
            marks.add(subjectMarks);
        }
    }

    public static void calculateResult() {
        for (int i = 0; i < marks.size(); i++) {

            int sum = 0;
            ArrayList<Integer> studentMarks = marks.get(i);

            // Calculate total
            for (int m : studentMarks) {
                sum += m;
            }
            total.add(sum);

            // Calculate percentage
            int percent = sum / studentMarks.size(); // 5 subjects
            percentage.add(percent);

            // Assign grade
            if (percent >= 80) {
                grade.add('A');
            } else if (percent >= 60) {
                grade.add('B');
            } else if (percent >= 40) {
                grade.add('C');
            } else {
                grade.add('F');
            }
        }
    }

    public static void displayAll() {
        System.out.println("\n--- Student List ---");
        System.out.println("name : " + students);
        System.out.println("Roll No : " + roll);
        System.out.println("Marks : " +marks);


    }


    public static void searchByRoll() {
        System.out.println("Enter roll number which you want to search : ");
        Scanner sc = new Scanner(System.in);
        int search = sc.nextInt();
        boolean isContain = false;
        if (roll.contains(search)) {
            isContain = true;
        }
        if (isContain) {
            System.out.println("Student with roll number " + search + " is exist");
        } else {
            System.out.println("Student with roll number does not exist");
        }
    }
    public static void findTopper(){
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        int topperIndex = 0;
        for (int i=1;i<total.size();i++){
            if (total.get(i) > total.get(topperIndex)) {
                topperIndex = i;
            }
            }
        System.out.println("TOPPER DETAILS");
        System.out.println("Name: " + students.get(topperIndex));
        System.out.println("Roll No: " + roll.get(topperIndex));
        System.out.println("Marks: " + marks.get(topperIndex));
        System.out.println("Total: " + total.get(topperIndex));
        System.out.println("Percentage: " + percentage.get(topperIndex) + "%");
        System.out.println("Grade: " + grade.get(topperIndex));
        }


    public static void findAverage(){
        int sum = 0;
        for (int i = 0; i < total.size(); i++) {
            sum += total.get(i);
        }
        double avg = sum / (double) total.size();
        System.out.println("Average Marks of class: " + avg);
    }
}