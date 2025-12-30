import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<Integer, Customer> customers = new HashMap<>();

    public void addAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
    }

    public Account getAccount(int accNo) {
        return accounts.get(accNo);
    }

    public void addCustomer(Customer c) {
        customers.put(c.getId(), c);
    }

    public Customer searchCustomer(int id) {
        return customers.get(id);
    }

    public void linkAccountToCustomer(int cid, int accNo) {
        Customer c = customers.get(cid);
        Account a = accounts.get(accNo);
        if (c == null || a == null)
            throw new IllegalArgumentException("Customer or Account not found");
        c.addAccount(a);
    }

    public void transferMoney(int from, int to, double amt)
            throws InsufficientBalanceException, MinimumBalanceException {

        Account a1 = accounts.get(from);
        Account a2 = accounts.get(to);

        a1.withdraw(amt);
        a2.deposit(amt);

        a1.addTransaction("TRANSFER_OUT", amt, "To " + to);
        a2.addTransaction("TRANSFER_IN", amt, "From " + from);
    }

    // ---------------- SAVE DATA ----------------
    public void saveData() throws Exception {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accounts.txt"))) {
            for (Account a : accounts.values()) {
                bw.write(a.getAccountNumber() + "," +
                        a.getHolderName() + "," +
                        a.getBalance() + "," +
                        a.getAccountType());
                bw.newLine();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt"))) {
            for (Customer c : customers.values()) {
                bw.write(c.getId() + "," + c.getName());
                for (Account a : c.getAccounts()) {
                    bw.write("," + a.getAccountNumber());
                }
                bw.newLine();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("transactions.txt"))) {
            for (Account a : accounts.values()) {
                for (Transaction t : a.getTransactionHistory()) {
                    bw.write(a.getAccountNumber() + "," +
                            t.getType() + "," +
                            t.getAmount() + "," +
                            t.getDateTime() + "," +
                            t.getDescription());
                    bw.newLine();
                }
            }
        }
    }

    // ---------------- LOAD DATA ----------------
    public void loadData() throws Exception {

        if (new File("accounts.txt").exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader("accounts.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    Account a = p[3].equals("SAVINGS")
                            ? new SavingAccount(p[1], Integer.parseInt(p[0]), Double.parseDouble(p[2]))
                            : new CurrentAccount(p[1], Integer.parseInt(p[0]), Double.parseDouble(p[2]));
                    accounts.put(a.getAccountNumber(), a);
                }
            }
        }

        if (new File("customers.txt").exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader("customers.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    Customer c = new Customer(Integer.parseInt(p[0]), p[1]);
                    customers.put(c.getId(), c);
                    for (int i = 2; i < p.length; i++) {
                        c.addAccount(accounts.get(Integer.parseInt(p[i])));
                    }
                }
            }
        }

        if (new File("transactions.txt").exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader("transactions.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    Account a = accounts.get(Integer.parseInt(p[0]));
                    a.addLoadedTransaction(
                            new Transaction(p[1],
                                    Double.parseDouble(p[2]),
                                    p[4],
                                    LocalDateTime.parse(p[3])));
                }
            }
        }
    }
}
