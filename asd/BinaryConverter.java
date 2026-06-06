import java.util.Scanner;

public class BinaryConverter {

    Scanner sc = new Scanner(System.in);

    public BinaryConverter() {
        System.out.println("Enter binary to convert: ");
        String binary = sc.nextLine();

        System.out.println("Choose convertion type: ");
        System.out.println("1. To Decimal");
        System.out.println("2. To Octal");
        System.out.println("3. To Hexadecimal");
        String operation = sc.nextLine();
    }
}
