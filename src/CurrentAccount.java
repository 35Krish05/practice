public class CurrentAccount extends Account {

    private static final double MIN_BAL = 2000;

    public CurrentAccount(String name, int accNo, double bal) {
        super(name, accNo, bal);
    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException, MinimumBalanceException {

        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance");

        if (balance - amount < MIN_BAL)
            throw new MinimumBalanceException("Minimum balance ₹2000 required");

        balance -= amount;
        addTransaction("WITHDRAW", amount, "Amount withdrawn");
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }
}
