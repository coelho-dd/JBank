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
        String name;
        String email;
        String password;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the following data:");
        System.out.println("Name:");
        name = scanner.nextLine();
        name = validateInput(name);

        // WTH am I doing lmao
    }

    public static String validateInput(String input) {
        Scanner scanner = new Scanner(System.in);
        if(input.isBlank()) {
            System.out.println("Please provide a valid input:");
            input = scanner.nextLine();
            validateInput(input);
        }
        return input;
    }
}