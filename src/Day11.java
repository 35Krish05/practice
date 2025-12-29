import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) {
     BankAcc b = new BankAcc();
        System.out.println("Enter amount that you want to withdraw : ");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        try {
            b.withdraw(money);
        }catch (InsufficientBalanceException e){
            e.printStackTrace();
        }



    }
}

