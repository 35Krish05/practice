import java.util.InputMismatchException;

import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) {
     BankAcc b = new BankAcc();

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter amount that you want to withdraw : ");
            double money = sc.nextDouble();
            b.withdraw(money);
        }catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch (InsufficientBalanceException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("❌ Something went wrong. Please try again.");
        }
        finally {
            sc.close();
            System.out.println("Program finished safely.");
        }
    }
}

