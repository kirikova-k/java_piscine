package  ex00;
public class User {
    private static int numberOfUsersCreated = 0;
    private String name;
    private int identifier;
    private int balance;

    public User(String _name, int initialBalance) {
        this.identifier = ++numberOfUsersCreated;
        this.name = _name;
        if (initialBalance < 0) {
            balance = 0;
        }
        else {
            balance = initialBalance;
        }
    }

    public void setBalance(int newBalance) {
        if (newBalance < 0) {
            return;
        }
        this.balance = newBalance;
    }

    public int getId() {
        return  identifier;
    }

    public int getBalance() {
        return  balance;
    }

    public String getName() {
        return  name;
    }
}
