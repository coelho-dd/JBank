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
        SavingsAccount savingsAccount = null;
        CheckingsAccount checkingsAccount = null;

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
                    if(savingsAccount == null) {
                        System.out.println("Please enter the initial balance for your saving account:");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine();
                        savingsAccount = new SavingsAccount(user, initialBalance);
                        System.out.println("Your savings account was created successfully.");
                    } else {
                        System.out.println("You already have an account.");
                    }
                    break;
                case "2":
                    if(checkingsAccount == null) {
                        System.out.println("Please enter the initial balance for your checking account:");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine();
                        checkingsAccount = new CheckingsAccount(user, initialBalance);
                        System.out.println("Your checking account was created successfully.");
                    } else {
                        System.out.println("You already have an account.");
                    }
                    break;
                case "3":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "deposit");
                    break;
                case "4":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "withdraw");
                    break;
                case "5":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "transfer");
                    break;
                case "6":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "bstatements");
                    break;
                case "7":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "balance");
                    break;
                case "8":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "loan");
                    break;
                case "9":
                    userChoice(user, savingsAccount, checkingsAccount, scanner, "interest");
                    break;
                case "0":
                    System.out.println("Logging you off...");
                    System.exit(0);
                default:
                    System.out.println("Option not valid. Try again");
            }
        }
    }

    public static void userChoice(User user, SavingsAccount savingsAccount, CheckingsAccount checkingsAccount, Scanner scanner, String operation) {
        String whichAccount;
        double amount;

        if(savingsAccount == null && checkingsAccount == null) {
            System.out.println("You don't have any accounts to perform this operation.");
            return;
        }

        System.out.println("Which account would you like to perform this operation on: 1- Savings Account / 2- Checkings Account");
        whichAccount = scanner.nextLine();

        if((whichAccount.equals("1") && savingsAccount == null) || (whichAccount.equals("2") && checkingsAccount == null)) {
            System.out.println("This account does not exist. Please create the account first.");
            return;
        }

        // detecting the account, the operation and executing it [NOT FINISHED] TODO: Apply transfer functionality
        // this is far from ideal code I know :)
        // 1- Savings Account | 2- Checkings Account
        if(whichAccount.equals("1")) {
            if(operation.equals("deposit")) {
                System.out.println("What is the amount:");
                amount = scanner.nextDouble();
                scanner.nextLine();
                savingsAccount.deposit(amount);
            } else if(operation.equals("withdraw")) {
                System.out.println("What is the amount:");
                amount = scanner.nextDouble();
                scanner.nextLine();
                savingsAccount.withdraw(amount);
            } else if(operation.equals("transfer")) {
                // still have to apply this functionality
            } else if(operation.equals("bstatements")) {
                savingsAccount.getBankStatements();
            } else if(operation.equals("balance")) {
                double balance = savingsAccount.getBalance();
                System.out.println("Your balance is $" + balance);
            } else if(operation.equals("loan")) {
                System.out.println("It's not possible to take loans with your savings account, only with your checkings account.");
            } else if(operation.equals("interest")) {
                System.out.println("What would be the amount you want to apply interest on?");
                double interestAmount = scanner.nextDouble();
                System.out.println("What would be the time(in months)?");
                int interestMonths = scanner.nextInt();
                savingsAccount.interestSim(interestMonths, interestAmount);
            }
        } else if(whichAccount.equals("2")) {
            if(operation.equals("deposit")) {
                System.out.println("What is the amount:");
                amount = scanner.nextDouble();
                scanner.nextLine();
                checkingsAccount.deposit(amount);
            } else if(operation.equals("withdraw")) {
                System.out.println("What is the amount:");
                amount = scanner.nextDouble();
                scanner.nextLine();
                checkingsAccount.withdraw(amount);
            } else if(operation.equals("transfer")) {
                // still have to apply this functionality
            } else if(operation.equals("bstatements")) {
                checkingsAccount.getBankStatements();
            } else if(operation.equals("balance")) {
                double balance = checkingsAccount.getBalance();
                System.out.println("Your balance is $" + balance);
            } else if(operation.equals("loan")) {
                System.out.println("What would be the amount of the loan?");
                double loanAmount = scanner.nextDouble();
                checkingsAccount.takeLoan(loanAmount);
            } else if(operation.equals("interest")) {
                System.out.println("It's not possible to apply interest with your checkings account, only with your savings account.");
            }
        }
    }
}