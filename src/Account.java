import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private int accountNumber;
    private String holderName;
    protected double balance;

    private List<Transaction> transactions = new ArrayList<>();

    public Account(String holderName, int accountNumber, double balance) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = Math.max(balance, 0);
    }

    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    protected void addTransaction(String type, double amount, String desc) {
        transactions.add(new Transaction(type, amount, desc));
    }

    public void addLoadedTransaction(Transaction t) {
        transactions.add(t);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
        addTransaction("DEPOSIT", amount, "Amount deposited");
    }

    public abstract void withdraw(double amount)
            throws InsufficientBalanceException, MinimumBalanceException;

    public abstract String getAccountType();
}
