import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);

        System.out.println("POLYMORPHISM BINARY CALCULATOR");
        System.out.println("1. Binary Arithmetic Operations ");
        System.out.println("2. Binary Conversion:" );
        System.out.print("Choose mode: ");
        int userChoice = sc.nextInt();

        switch(userChoice) {
            case 1:
                BinaryCalculator binaryCalculator = new BinaryCalculator();
                break;
            case 2:
                BinaryConverter binaryConverter = new BinaryConverter();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}