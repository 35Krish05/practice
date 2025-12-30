import java.util.Scanner;

public class Day14_15 {

    public static void main(String[] args) {

        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        //  LOAD DATA ON START
        try {
            bank.loadData();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }

        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Money");
            System.out.println("6. Show Transaction History");
            System.out.println("7. Show Customer Accounts");
            System.out.println("8. Save & Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    //  ADD CUSTOMER
                    case 1:
                        System.out.print("Enter Customer ID: ");
                        int cid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String cname = sc.nextLine();

                        bank.addCustomer(new Customer(cid, cname));
                        System.out.println("Customer added successfully!");
                        break;

                    //  CREATE ACCOUNT
                    case 2:
                        System.out.print("Enter Customer ID: ");
                        int custId = sc.nextInt();

                        Customer cust = bank.searchCustomer(custId);
                        if (cust == null) {
                            System.out.println("Customer not found!");
                            break;
                        }

                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();

                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();

                        System.out.print("Account Type (1-Savings, 2-Current): ");
                        int type = sc.nextInt();

                        Account acc = (type == 1)
                                ? new SavingAccount(cust.getName(), accNo, bal)
                                : new CurrentAccount(cust.getName(), accNo, bal);

                        bank.addAccount(acc);
                        bank.linkAccountToCustomer(custId, accNo);

                        System.out.println("Account created & linked successfully!");
                        break;

                    //  DEPOSIT
                    case 3:
                        System.out.print("Enter Account Number: ");
                        int depAcc = sc.nextInt();

                        Account depAccount = bank.getAccount(depAcc);
                        if (depAccount == null) {
                            System.out.println("Account not found!");
                            break;
                        }

                        System.out.print("Enter Amount: ");
                        double depAmt = sc.nextDouble();

                        depAccount.deposit(depAmt);
                        System.out.println("Deposit successful!");
                        break;

                    //  WITHDRAW
                    case 4:
                        System.out.print("Enter Account Number: ");
                        int withAcc = sc.nextInt();

                        Account withAccount = bank.getAccount(withAcc);
                        if (withAccount == null) {
                            System.out.println("Account not found!");
                            break;
                        }

                        System.out.print("Enter Amount: ");
                        double withAmt = sc.nextDouble();

                        withAccount.withdraw(withAmt);
                        System.out.println("Withdrawal successful!");
                        break;

                    //  TRANSFER
                    case 5:
                        System.out.print("From Account: ");
                        int from = sc.nextInt();

                        System.out.print("To Account: ");
                        int to = sc.nextInt();

                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();

                        bank.transferMoney(from, to, amt);
                        System.out.println("Transfer successful!");
                        break;

                    //  TRANSACTION HISTORY
                    case 6:
                        System.out.print("Enter Account Number: ");
                        int histAcc = sc.nextInt();

                        Account a = bank.getAccount(histAcc);
                        if (a == null) {
                            System.out.println("Account not found!");
                            break;
                        }

                        System.out.println("\n--- Transaction History ---");
                        for (Transaction t : a.getTransactionHistory()) {
                            System.out.println(t);
                        }
                        break;

                    //  CUSTOMER ACCOUNTS
                    case 7:
                        System.out.print("Enter Customer ID: ");
                        int searchId = sc.nextInt();

                        Customer found = bank.searchCustomer(searchId);
                        if (found == null) {
                            System.out.println("Customer not found!");
                            break;
                        }

                        System.out.println("Customer: " + found.getName());
                        for (Account ac : found.getAccounts()) {
                            System.out.println(
                                    "Account No: " + ac.getAccountNumber() +
                                            ", Type: " + ac.getAccountType() +
                                            ", Balance: " + ac.getBalance()
                            );
                        }
                        break;

                    //  SAVE & EXIT
                    case 8:
                        bank.saveData();
                        System.out.println("Data saved. Program exited.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
