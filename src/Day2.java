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
    }
}
