public class CheckingsAccount extends Account {

	public CheckingsAccount(User accountOwner, double balance) {
		super(accountOwner, balance);
	}

	public boolean takeLoan(double value) {
		if(this.getBalance() < 1000) {
			System.out.println("Sorry, you do not have the minimum amount to take a loan.");
			return false;
		}
		this.setBalance(this.getBalance() + value);
		System.out.println("Your loan was taken successfully.");
		return true;
	}
}