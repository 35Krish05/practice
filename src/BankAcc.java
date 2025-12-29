public class BankAcc {
    private double balance = 50000;
    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount > balance){
            throw new InsufficientBalanceException("Your balance is Insufficient");
        }
        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.println("Now your balance is : " + balance);

    }

}
