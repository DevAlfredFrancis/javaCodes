import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userName;
    private String mobile;
    private String email;
    private String pin;
    private double balance;
    
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();

    //Constructor
    public User(String userName, String mobile, String email, String pin, double  balance) {
        this.userName = userName;
        this.mobile = mobile;
        this.email = email;
        this.pin = pin;
        this.balance = balance;
    }

    //getters
    public String getUserName() { return userName; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getPin() { return  pin; }
    public double  getBalance() { return  balance; }
    public ArrayList<User> getUsers() { return users; };

    //user register
    public static User register() {
        String name;
        String mobileNumber;
        String email;
        String pin;
        double initialDeposit;

        //name validation, exit loop if name is valid
        while(true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine().trim();

            if(isLettersOnly(name)) {
                break;
            }else {
                System.out.println("Please enter a valid name.");
            }
        }

        //mobile validation, exit loop if mobile number is valid
        while(true) {
            System.out.print("Enter mobile number: ");
            mobileNumber = sc.next().trim();

            if(mobileNumber.matches("\\+?\\d{10,13}")) {
                break;
            }else {
                System.out.println("Please enter a valid mobile number.");
            }
        }
        
        //email validation, exit loop if email is valid
        while (true) { 
            System.out.print("Enter email: ");
            email = sc.next().trim();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                break;
            }else {
                System.out.println("Please enter a valid email address.");
            }
        }

        //PIN validation, exit loop if PIN is valid
        while(true) { 
            System.out.print("Enter 4-digit PIN: ");
            pin = sc.next().trim();
            
            if(pin.matches("\\d{4}")) {
                break;
            }else {
                System.out.println("Invalid PIN! It must be exactly 4 digits (0-9). Try again");
            }
        }

        //initialDeposit validation
        while(true) { 
            System.out.print("Initial Deposit: ");
            initialDeposit = sc.nextDouble();
            
            if(initialDeposit <= 0) {
                System.out.println("Invalid amount, must be a positive value");
            }else {
                System.out.println("Deposit Successfully!");
                break;
            }
        }

        //create a new user object
        User newUser = new User(name, mobileNumber, email, pin, initialDeposit);
        users.add(newUser);
        System.out.println("Register Successfully!");

        return newUser;
    }

    //input validation, preventing user to input numbers in Names
    public static boolean isLettersOnly(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
            return false; // found a non-letter and non-space char
            }
        }

        return true; // all letters or spaces
    }

    //login with mobile number
    public static User loginWithMobile(String mobile, String pin) {
        for(User u : users) {
            if(u.getMobile().equals(mobile) && u.getPin().equals(pin)) {
                //login in successful
                return u;
            }
        }

        //login failed
        return null; 
    }

    //login with email
    public static User loginWithEmail(String email, String pin) {
        for(User u : users) {
            if(u.getEmail().equals(email) && u.getPin().equals(pin)) {
                //login in successful
                return u;
            }
        }

        //login failed
        return null; 
    }


    @Override
    public String toString() {
        return "User{mobile='" + mobile + "', email='" + email + "'}";
    }
    
}
