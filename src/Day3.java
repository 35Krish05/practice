import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
//control flow - conditional statement
         //if if-else if-else-if lader
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your marks : ");
        int marks = sc.nextInt();
      if(marks >= 35 ) {
          System.out.print("Pass and ");
          if (marks >= 80) {
              System.out.println("GRADE = A");
          } else if (marks >= 60 && marks < 80) {
              System.out.println("GRADE = B");
          } else {
              System.out.println("GRADE = C");
          }
      }
        else {
              System.out.println("Fail ");
          }
//Nested if statements
       if (marks >= 35) {
           if (marks >= 90 ){
               System.out.println("You got prize iphone");
           }else {
               System.out.println("you got Nothing");
           }
       }

//Ternary operator
         int a=10,b=20;
         int max = (a<b) ? b : a ;
        System.out.println("Maximum number is : " + max);

//switch case statements (including new enhanced switch from java 14+)
        int day = 3;

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Invalid day");
        }
//task - 2 : simple menu driven program using switch (calculator with menu)
        String grade = switch (marks / 10) {
            case 10, 9 -> "A";
            case 8, 7 -> "B";
            case 6 -> "C";
            default -> "Fail";
        };

        System.out.println("Grade: " + grade);
    }
}
