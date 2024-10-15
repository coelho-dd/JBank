import java.util.ArrayList;

abstract class Account {
    private User accountOwner;
    private double balance;
    private ArrayList<Double> bankStatements; // An ArrayList in Java is the implementation of a dynamic array(since we do not know the size from the start)

    public Account(User accountOwner, double balance) {
        this.accountOwner = accountOwner;
        this.balance = balance;
        bankStatements = new ArrayList<>();
    }

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
}
