import java.util.ArrayList;

abstract class Account {
    private User accountOwner;
    private double balance;
    private ArrayList<Double> bankStatements; // ArrayList = dynamic array(since we do not know the exact amount of elements)

    public Account(User accountOwner, double balance) {
        this.accountOwner = accountOwner;
        accountOwner.setAccount(this);
        this.balance = balance;
        bankStatements = new ArrayList<>();
    }

    protected boolean withdraw(double value) {
        if(value > this.getBalance()) {
            System.out.println("Please provide a valid number to withdraw.");
            return false;
        }
        this.setBalance(this.getBalance() - value);
        System.out.println("Your withdraw was successfully executed.");
        return true;
    }

    protected boolean deposit(double value) {
        if(value > 0) {
            this.setBalance(this.getBalance() + value);
            System.out.println("Your deposit was successfully executed.");
            return true;
        }
        System.out.println("Please provide a valid number to deposit.");
        return false;
    }

    protected boolean transfer(Account acc, double value) {
        if(value > 0) {
            acc.setBalance(acc.getBalance() + value);
            this.setBalance(this.getBalance() - value);
            System.out.println("The transfer was executed successfully.");
            return true;
        }
        System.out.println("Please provide a valid number to transfer.");
        return false;
    }

    //TODO: Set up getters and setters to return correct values

    // getters and setters
    protected String getAccountOwner() {
        return accountOwner.getName();
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
