import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }
}
