public class Day6 {
    public static void main(String[] args) {


                BankAccount account = new BankAccount("Rahul Sharma", 10101, 5000);

                account.checkBalance();
                account.deposit(2000);
                account.checkBalance();
                account.withdraw(1500);
                account.checkBalance();
                account.withdraw(10000);
                account.checkBalance();
    }
}
     class BankAccount {

        // 🔒 Data members (Encapsulation)
        private String accountHolderName;
        private int accountNumber;
        private double balance;

        // 🧱 Constructor
        public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
            this.accountHolderName = accountHolderName;
            this.accountNumber = accountNumber;
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                this.balance = 0;
                System.out.println("Initial balance cannot be negative. Balance set to 0.");
            }
        }

        // 💰 Deposit method
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // 💸 Withdraw method
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance!");
            } else {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully.");
            }
        }

        // 📊 Check balance
        public void checkBalance() {
            System.out.println("Current Balance: ₹" + balance);
        }
    }
