import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
//variable declaration and initialization
     int a = 10;
     float f = 1.2f;
     double d = 1.232345654;
     long l = 1234656455;
     char c = 'k';
     boolean b = true;
//type casting
        //implicit(widening)
        System.out.println("Implicit type casting : ");
        float f2 = a;
        double d2 = f2;
        System.out.println("FLOAT : " + f2);
        System.out.println("Double : " + d2);
        //Explicit
        System.out.println("Explicit type casting : ");
        int i = (int) d;
        System.out.println("INTEGER : " + i );
//constant using final keyword
         final int i1 = 10;
       //  i1 = 20; this gives error because : Cannot assign a value to final variable 'i1'
//Arithmetic operator
        System.out.println("Arithmetic operator : ");
        int j = 10 , k=20;
        System.out.println(j+k);
        System.out.println(k-j);
        System.out.println(j*k);
        System.out.println(k/j);
        System.out.println(k%j);

//relational operator
        System.out.println("relational operator : ");
        System.out.println( j == k ); // false
        System.out.println(j != k );  //true
        System.out.println(j<k); // true
        System.out.println(j>k); //false

 //logical operators
        System.out.println("logical operator : ");
        int a1=10,b1=10,c1=20;
        if ((a1<c1) && (b1<c1)){
            System.out.println("this is logical AND");
        }
        if ((a1<c1) || (b1<c1)){
            System.out.println("this is logical OR");
        }
//Assignment operator
        System.out.println("assignment operator : ");
       int a2 = 20;
        System.out.println( " a = " + a);
       a2 += 10;
        System.out.println( " a = " + a);
       a2 -= 10;
        System.out.println( " a = " + a);

        System.out.println("Calculator Program : ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number :  ");
        int n1 =  sc.nextInt();
        System.out.print("Enter first number :  ");
        int n2 =  sc.nextInt();
        System.out.println(" n1 + n2 = " + (n1+n2));
        System.out.println(" n1 - n2 = " + (n1-n2));
        System.out.println(" n1 * n2 = " + (n1*n2));
        System.out.println(" n1 / n2 = " + (n1/n2));


    }
}
