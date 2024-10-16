public class CheckingsAccount extends Account {

	public CheckingsAccount(User accountOwner, double balance) {
		super(accountOwner, balance);
	}

	public boolean takeLoan(double value) {
		if(this.getBalance() < 1000) {
			System.out.println("Sorry, ou do not have the minimum amount to take a loan.");
			return false;
		}
		this.setBalance(this.getBalance() + value);
		System.out.println("Your loan was taken successfully.");
		return true;
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