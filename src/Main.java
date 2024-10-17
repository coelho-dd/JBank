import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("WELCOME TO JBANK!!!");
        System.out.println("=====================================\n");

        do {
            System.out.println("Do you want to register in our bank?[yes/no]:");
            userInput = scanner.nextLine();
        } while(!userInput.equalsIgnoreCase("yes") && !userInput.equalsIgnoreCase("no"));
        
        userInput = userInput.toLowerCase();
        
        if(userInput.equals("yes")) {
            registration();
        } else {
            System.out.println("Come back any time!");
        }
    }

    public static void registration() {
        Scanner scanner = new Scanner(System.in);

        String name = validateInput("Name", scanner);
        String email = validateInput("Email", scanner);
        String password = validateInput("Password", scanner);

        User user = new User(name, email, password);
        System.out.println("Registration successfull for " + user.getName());

        scanner.close();
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
}