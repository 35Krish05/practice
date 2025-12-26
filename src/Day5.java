import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Day5 {
    public static void main(String[] args) {
//create a program to manage student names(add,display,search,sort)
                ArrayList<String> students = new ArrayList<>();
                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.println("\n===== Student Management System =====");
                    System.out.println("1. Add Student");
                    System.out.println("2. Display Students");
                    System.out.println("3. Search Student");
                    System.out.println("4. Sort Students");
                    System.out.println("5. Exit");
                    System.out.print("Choose option: ");

                    int choice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (choice) {

                        case 1:
                            System.out.print("Enter student name: ");
                            String name = sc.nextLine();
                            students.add(name);
                            System.out.println("Student added successfully!");
                            break;

                        case 2:
                            if (students.isEmpty()) {
                                System.out.println("No students found.");
                            } else {
                                System.out.println("Student List:");
                                for (String student : students) {
                                    System.out.println(student);
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Enter name to search: ");
                            String searchName = sc.nextLine();
                            boolean found = false;

                            for (String student : students) {
                                if (student.equalsIgnoreCase(searchName)) {
                                    found = true;
                                    break;
                                }
                            }

                            if (found) {
                                System.out.println("Student found!");
                            } else {
                                System.out.println("Student not found!");
                            }
                            break;

                        case 4:
                            Collections.sort(students);
                            System.out.println("Students sorted successfully!");
                            break;

                        case 5:
                            System.out.println("Exiting program. Bye!");
                            sc.close();
                            return;

                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                }
            }
        }
