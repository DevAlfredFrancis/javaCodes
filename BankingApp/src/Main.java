import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String userName;
        int userChoice,  userPin, userAccountType, initialDeposit = 0;
        Map<String, User> users = new HashMap<>(); //local storage for users credentials

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("------------------------------------------------------------------");
            System.out.println("Welcome to the Multi-Tier Bank Account Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();

            switch (userChoice) { //Welcome to prompt (user will choose between 1.register 2.Login or 3.Exit)
                case 1: //REGISTRATION
                    System.out.println("------------- REGISTRATION -------------");
                    System.out.print("Input your desire username: ");
                    userName = sc.next();

                    while (true) { //validate 4-digits PIN
                        System.out.print("Input your desire PIN: ");
                        userPin = sc.nextInt();
                        if(userPin >= 1111 && userPin <= 9999) {
                            break;
                        }else {
                            System.out.println("Please input 4-digits only.");
                        }
                    }

                    while (true) { //validate account type
                        System.out.println("Choice account type: ");
                        System.out.println("1. Savings");
                        System.out.println("2. Current");
                        System.out.print("Enter your choice: ");
                        userAccountType = sc.nextInt();

                        switch (userAccountType) { //user will choose between savings account or current account
                            case 1:
                                while (true) {
                                    System.out.print("Enter your initial deposit: ");
                                    initialDeposit = sc.nextInt();

                                    if(initialDeposit >= 1000) { // savings account minimum balance is 1000
                                        System.out.println("Congratulations, your account has been successfully created.");
                                        break;
                                    } else {
                                        System.out.println("Invalid deposit. Minimum balance for a savings account is 1000.");
                                    }
                                }
                                break;
                            case 2:
                                while (true) {
                                    System.out.print("Enter your initial deposit: ");
                                    initialDeposit = sc.nextInt();

                                    if(initialDeposit >= 5000) { // current account minimum balance is 5000
                                        System.out.println("Congratulations, your account has been successfully created.");
                                        break;
                                    } else {
                                        System.out.println("Invalid deposit. Minimum balance for a current account is 5000.");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid input, please select savings or current!");
                        }
                        break;
                    }
                    users.put(userName, new User(userPin, initialDeposit, userAccountType));
                    break;
                case 2: // LOGIN
                    int loginAttemptsLeft = 3;
                    boolean isLoggedIn = false;

                    System.out.println("------------- LOGIN -------------");

                    while (loginAttemptsLeft > 0 && !isLoggedIn) {
                        System.out.print("Enter your username: ");
                        String username = sc.next();

                        System.out.print("Enter your user PIN: ");
                        userPin = sc.nextInt();

                        // Validate user credentials
                        User user = users.get(username); // Retrieve user object
                        if(user != null && user.getPin() == userPin) {
                            isLoggedIn = true;
                            boolean sessionActive = true;
                            while (sessionActive) { // Display user menu
                                System.out.println("------------------------------------------------------------------");
                                System.out.println("Welcome, " + username);
                                System.out.println("1. Check Balance");
                                System.out.println("2. Deposit Money");
                                System.out.println("3. Withdraw Money");
                                System.out.println("4. Calculate Interest (Savings only)");
                                System.out.println("5. Logout");
                                System.out.print("Enter your choice: ");

                                int loginChoice = sc.nextInt();
                                switch (loginChoice) { // Post Login Menu
                                    case 1: //check balance
                                        System.out.println("Your current balance is: " + user.getBalance());
                                        break;
                                    case 2: //deposit money
                                        while (true) {
                                            System.out.print("Amount to be deposit: ");
                                            double depositAmount = sc.nextDouble();
                                            if(depositAmount > 0) {
                                                user.depositMoney(depositAmount);
                                                break;
                                            }else {
                                                System.out.println("Invalid amount. Must be a positive value.");
                                            }
                                        }
                                        break;
                                    case 3: //withdraw money
                                        System.out.print("Amount to be withdraw: ");
                                        double withdrawAmount = sc.nextDouble();
                                        user.withdrawMoney(user.getAccountType() , withdrawAmount);
                                        break;
                                    case 4: // calculate interest
                                        if(user.getAccountType() == 1) {
                                            User.computeInterest(user.getBalance());
                                        }else {
                                            System.out.println("This feature is not available for Current accounts.");
                                        }
                                        break;
                                    case 5: //logout
                                        System.out.println("Logging out...");
                                        sessionActive = false;
                                        break;
                                    default:
                                        System.out.println("Invalid input! Please try again.");
                                        break;
                                }
                            }
                        } else {
                            loginAttemptsLeft--;
                            System.out.println("Incorrect credentials. Please try again.");
                        }

                        if(loginAttemptsLeft == 0) {
                            System.out.println("Account locked due to multiple failed login attempts.");
                            System.out.println("Please contact customer service for assistance.");
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}