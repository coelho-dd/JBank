public class SavingsAccount extends Account {

	public SavingsAccount(User accountOwner, double balance) {
		super(accountOwner, balance);
	}

	public void interestSim(int months, double value) {
		double total = value * Math.pow((1 + 0.01), months);
		System.out.println("By the end of " + months + " months your balance will be $" + total + ".");
	}

	@Override
	boolean deposit(double value) {
		if(value > 0) {
			this.setBalance(this.getBalance() + value);
			System.out.println("Your deposit was successfully executed.");
			return true;
		}
		System.out.println("Please provide a valid number to deposit.");
		return false;
	}

	@Override
	boolean withdraw(double value) {
		if(value > this.getBalance()) {
			System.out.println("Please provide a valid number to withdraw.");
			return false;
		}
		this.setBalance(this.getBalance() - value);
		System.out.println("Your withdraw was successfully executed.");
		return true;
	}

	@Override
	boolean transfer(Account acc, double value) {
		if(value > 0) {
			acc.setBalance(acc.getBalance() + value);
			this.setBalance(this.getBalance() - value);
			System.out.println("The transfer was executed successfully.");
			return true;
		}
		System.out.println("Please provide a valid number to transfer.");
		return false;
	}
}