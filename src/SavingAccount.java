public class SavingAccount extends Account {

    public SavingAccount(String name, int accNo, double bal) {
        super(name, accNo, bal);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance");
        balance -= amount;
        addTransaction("WITHDRAW", amount, "Amount withdrawn");
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }
}
