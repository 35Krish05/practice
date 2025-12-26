import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
//Task 1 : print pattern  ( pyramid , diamond, number pattern)
        System.out.println("Pyramid pattern: ");
         //pyramid
        for (int i=0;i<=4;i++){
            for (int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        //diamond
        System.out.println("Diamond pattern: ");
        int n=4;
        for(int i=0; i<=n;i++){
               //space
            for (int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            //star
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1; i>=0;i--){
            //space
            for (int j=n-i;j>0;j--){
                System.out.print(" ");
            }
            //star
            for (int j=i;j>=1;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        //number pattern
        System.out.println("Number pattern: ");
        for (int i=1;i<=4;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }

//Task-2 :- multiplication table generator
        System.out.print("Enter the number which you want to generate multiplication table : ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i=1;i<=10;i++){
            System.out.printf("%d * %d = %d" , m,i,m*i);
            System.out.println();
        }
//task-3 :- find factorial , fibonacci series
        //find factorial
        int a = 5;
        int fact = 1;
        for (int i=a ; i>=1;i--){
            fact *= i;
        }
        System.out.println("factorial of 5 is : " + fact);
        //fibonacci series
        int n1 = 0, n2 = 1;

        for (int i = 0; i < 10; i++) {
            // Print the number
            System.out.print(n1 + " ");
            // Swap
            int n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
        }
    }
}
