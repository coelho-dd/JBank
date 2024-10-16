import java.util.ArrayList;

abstract class Account {
    private User accountOwner;
    private double balance;
    private ArrayList<Double> bankStatements; // ArrayList = dynamic array(since we do not know the exact amount of elements)

    public Account(User accountOwner, double balance) {
        this.accountOwner = accountOwner;
        this.balance = balance;
        bankStatements = new ArrayList<>();
    }

    // TODO: The following 3 methods will have the exact same logic in each subclass!!! [Solve this]
    abstract boolean withdraw(double value);
    abstract boolean deposit(double value);
    abstract boolean transfer(Account acc, double value);

    protected User getAccountOwner() {
        return accountOwner;
    }

    protected double getBalance() {
        return balance;
    }

    public ArrayList<Double> getBankStatements() {
        return bankStatements;
    }

    protected void setAccountOwner(User accountOwner) {
        this.accountOwner = accountOwner;
    }

    protected void setBalance(double value) {
        this.balance = value;
    }
}
