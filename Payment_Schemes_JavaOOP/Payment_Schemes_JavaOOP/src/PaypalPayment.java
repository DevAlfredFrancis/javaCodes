import java.util.Scanner;

public class PaypalPayment implements Payment {
    private String validAccount;
    private User user;
    
    //Constructor
    public PaypalPayment(User user) {
        this.user = user;
    }

    //Paypal menu option
    public static void paypalMenu() {
        String userInput;
        String mobile, email, pin;
        boolean exitPaypalMenu = false;
        Scanner sc = new Scanner(System.in);

        do { 
            System.out.println("Please Login your paypal account:");
            System.out.println("1. Mobile Number");
            System.out.println("2. Email");
            System.out.println("3. Register New Account");
            System.out.println("4. Exit");

            while (true) { 
                System.out.print("Enter your choice: ");
                userInput = sc.next().trim();
                
                if(userInput.matches("[1-4]")) {
                    break;
                }else {
                    System.out.println("Invalid option! Please enter 1, 2, 3, or 4");
                }
            }

            switch (userInput) {
                case "1" -> {
                    //login via mobile number
                    System.out.print("Enter your mobile number: ");
                    mobile = sc.next().trim();
                    
                    System.out.print("Enter your PIN: ");
                    pin = sc.next().trim();

                    User loginByMobile = User.loginWithMobile(mobile, pin);
                    if(loginByMobile != null) {
                        System.out.println("Login successful! Welcome " + loginByMobile.getUserName());
                        exitPaypalMenu = true;
                        break;
                    }else {
                        System.out.println("Invalid mobile or PIN");
                    }
                    break;
                }
                case "2" -> {
                    //login via email
                    System.out.print("Enter your email: ");
                    email = sc.next().trim();
                    
                    System.out.print("Enter your PIN: ");
                    pin = sc.next().trim();

                    User loginByEmail = User.loginWithEmail(email, pin);
                    if(loginByEmail != null) {
                        System.out.println("Login successful! Welcome " + loginByEmail.getUserName());
                        exitPaypalMenu = true;
                    }else {
                        System.out.println("Invalid mobile or PIN");
                    }
                    break;
                }
                case "3" -> {
                    //register new paypal account
                    User.register();                       
                }
                case "4" -> {
                    //Exit paypal menu
                    System.out.println("Exiting...");
                    exitPaypalMenu = true;
                }
                default -> System.out.println("Invalid input!");
            }
        } while (!exitPaypalMenu);
    }
    
    public void authenticateUser() {
        System.out.println("authenticating");
    }

    public void processPayment() {
        System.out.println("Test");
    }
}
