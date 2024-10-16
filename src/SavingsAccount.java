public class SavingsAccount extends Account {
	private static final double INTEREST_RATE = 0.01;

	public SavingsAccount(User accountOwner, double balance) {
		super(accountOwner, balance);
	}

	public void interestSim(int months, double value) {
		double total = value * Math.pow((1 + INTEREST_RATE), months);
		System.out.println("By the end of " + months + " months your balance will be $" + total + ".");
	}
}