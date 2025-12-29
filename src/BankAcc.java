public class BankAcc {
    private double balance = 50000;
    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount > balance){
            throw new InsufficientBalanceException("Your balance is Insufficient");
        }
        balance -= amount;
        System.out.println("Now your balance is : " + balance);

    }

}
