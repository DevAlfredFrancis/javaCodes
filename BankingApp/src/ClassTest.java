import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ClassTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, User> users = new HashMap<>();

        // Create a new user
        System.out.print("Input your desired username: ");
        String userName = sc.next();

        System.out.print("Input your desired PIN: ");
        int userPin = sc.nextInt();

        System.out.print("Deposit amount: ");
        int depAmount = sc.nextInt();

        System.out.print("Account type: ");
        int accountType = sc.nextInt();

        // Add the user to the system
        users.put(userName, new User(userPin, depAmount, accountType));
        System.out.println("Account created successfully!");
        System.out.println(users);

        // Login
        System.out.print("Input your username: ");
        String authUser = sc.next();

        System.out.print("Input your PIN: ");
        int authPin = sc.nextInt();

        // Validate login
        if (users.containsKey(authUser)) {
            User user = users.get(authUser);
            if (user.getPin() == authPin) {
                System.out.println("Success Login!");
                System.out.println("Your current balance is: " + user.getBalance());
            } else {
                System.out.println("Invalid PIN. Login failed.");
            }
        } else {
            System.out.println("User does not exist. Login failed.");
        }
    }
}
