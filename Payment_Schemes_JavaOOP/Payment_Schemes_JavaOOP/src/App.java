import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        boolean isValid;
        String mobileNumber, email, pin, userInput;

        //Menu option, exit loop if option is valid
        while(true) {
            System.out.println("Choose a payment method: ");
            System.out.println("1. Credit card");
            System.out.println("2. PayPal");
            System.out.println("3. GCash");
            System.out.println("4. Bank Transfer");
            
            System.out.print("Enter menu option: ");
            userInput = sc.next().trim();

            if(userInput.matches("[1-4]")) {
                break;
            }else {
                System.out.println("Invalid option! Please enter 1, 2, 3, or 4.");
            }
        }
        
        switch (userInput) {
            case "2" -> {
                PaypalPayment.paypalMenu();

                
                //         isValid = paypal.mobileValidation(mobileNumber) && paypal.mobileValidation(pin);
                //     } while (!isValid);
                // }else if(userInput.equals("2")) {
                //     do { 
                //         System.out.print("Enter your email:");
                //         email = sc.next();
                //         System.out.print("Enter your PIN: ");
                //         pin = sc.next();
                //         isValid = paypal.emailValidation(email) && paypal.emailValidation(pin);
                //     } while (!isValid);
                //     // paypal.authenticate();
                // }else {
                // }
                // paypal.authenticate();
            }
            default -> throw new AssertionError();
        }
    }
}
