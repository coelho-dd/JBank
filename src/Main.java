import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user;
        String userInput;

        System.out.println("WELCOME TO JBANK!!!");
        System.out.println("=====================================\n");

        do {
            System.out.println("Do you want to register in our bank?[yes/no]:");
            userInput = scanner.nextLine();
        } while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"));
        
        userInput = userInput.toLowerCase();
        
        if(userInput.equals("yes")) {
            user = registration();
        } else {
            System.out.println("Come back any time!");
            return;
        }

        menu(user, scanner);
    }

    public static User registration() {
        Scanner scanner = new Scanner(System.in);

        String name = validateInput("Name", scanner);
        String email = validateInput("Email", scanner);
        String password = validateInput("Password", scanner);

        User user = new User(name, email, password);
        System.out.println("Registration successfull for user: " + user.getName() + ".\n");

        return user;
    }

    public static String validateInput(String data, Scanner scanner) {
        String input;
        do {
            System.out.println("Please provide your " + data + ":");
            input = scanner.nextLine();
            if(input.isBlank()) {
                System.out.println(data + " cannot be blank. Please provide a valid input.");
            }
        } while(input.isBlank());
        return input;
    }

    public static void menu(User user, Scanner scanner) {
        String input;

        System.out.println("ACCOUNT MENU");
        System.out.println("=====================================\n");

        System.out.println("To select an option below, enter their respective numbers:");
        System.out.println("1- Create savings account");
        System.out.println("2- Create checking account");
        System.out.println("3- Deposit");
        System.out.println("4- Withdraw");
        System.out.println("5- Transfer");
        System.out.println("6- Check banking statements");
        System.out.println("7- Check balance");
        System.out.println("8- Simulate a loan");
        System.out.println("9- Simulate interest operation");
        System.out.println("0- Log off");

        while(true) {
            input = scanner.nextLine();
            switch(input) {
                case "1":
                    System.out.println("created a savings account.");
                    break;
                case "2":
                    System.out.println("created checking account");
                    break;
                case "3":
                    System.out.println("deposited");
                    break;
                case "4":
                    System.out.println("just did that");
                    break;
                case "5":
                    System.out.println("yes");
                    break;
                case "6":
                    System.out.println("did it again");
                    break;
                case "7":
                    System.out.println("another one");
                    break;
                case "8":
                    System.out.println("just like the last one");
                    break;
                case "9":
                    System.out.println("the last one");
                    break;
                case "0":
                    System.out.println("Logging you off...");
                    System.exit(0);
                default:
                    System.out.println("Option not valid. Try again");
            }
        }
    }
}