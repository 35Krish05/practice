import java.util.Scanner;

public class Week1 {
    static Scanner sc = new Scanner(System.in);
    static int studentCount;
    static String[] names;
    static int[] rolls;
    static int[][] marks;
    static int[] total;
    static double[] percentage;
    static char[] grade;
    public static void main(String[] args) {

        System.out.print("Enter number of students: ");
        studentCount = sc.nextInt();

        names = new String[studentCount];
        rolls = new int[studentCount];
        marks = new int[studentCount][5];
        total = new int[studentCount];
        percentage = new double[studentCount];
        grade = new char[studentCount];

        inputData();
        calculateResult();

        while (true) {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT =====");
            System.out.println("1. Display All Students");
            System.out.println("2. Search Student by Roll No");
            System.out.println("3. Find Topper");
            System.out.println("4. Find Average Marks");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

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

    // Input student data
    static void inputData() {
        for (int i = 0; i < studentCount; i++) {
            sc.nextLine();
            System.out.println("\nEnter details of student " + (i + 1));
            System.out.print("Name: ");
            names[i] = sc.nextLine();

            System.out.print("Roll No: ");
            rolls[i] = sc.nextInt();

            System.out.println("Enter marks of 5 subjects:");
            for (int j = 0; j < 5; j++) {
                marks[i][j] = sc.nextInt();
            }
        }
    }

    // Calculate total, percentage, grade
    static void calculateResult() {
        for (int i = 0; i < studentCount; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += marks[i][j];
            }
            total[i] = sum;
            percentage[i] = sum / 5.0;

            if (percentage[i] >= 90)
                grade[i] = 'A';
            else if (percentage[i] >= 75)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else
                grade[i] = 'D';
        }
    }

    // Display all students
    static void displayAll() {
        System.out.println("\nRoll\tName\tTotal\tPercent\tGrade");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(rolls[i] + "\t" + names[i] + "\t" +
                    total[i] + "\t" + percentage[i] + "\t" + grade[i]);
        }
    }

    // Search by roll number
    static void searchByRoll() {
        System.out.print("Enter roll number to search: ");
        int r = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (rolls[i] == r) {
                System.out.println("\nName: " + names[i]);
                System.out.println("Total: " + total[i]);
                System.out.println("Percentage: " + percentage[i]);
                System.out.println("Grade: " + grade[i]);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Student not found!");
    }

    // Find topper
    static void findTopper() {
        int max = total[0];
        int index = 0;

        for (int i = 1; i < studentCount; i++) {
            if (total[i] > max) {
                max = total[i];
                index = i;
            }
        }

        System.out.println("\nTopper:");
        System.out.println("Name: " + names[index]);
        System.out.println("Roll No: " + rolls[index]);
        System.out.println("Total Marks: " + total[index]);
    }

    // Find average marks
    static void findAverage() {
        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += total[i];
        }
        double avg = sum / (double) studentCount;
        System.out.println("Average Marks of class: " + avg);
    }
}
