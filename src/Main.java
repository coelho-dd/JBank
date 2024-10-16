public class Main {
    public static void main(String[] args) {
        User user1 = new User("Davi", "davi@gmail.com", "davi123");
        CheckingsAccount acc1 = new CheckingsAccount(user1, 1000.0);

        System.out.println(user1.getAccount().getAccountOwner());
    }
}