import java.util.Scanner;

public class ArithmeticOp{

    public static void main(String[] args) {
        //input
        char opSymbol;
        int num1, num2, res;

        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Arithmetic Menu");
        System.out.println("A. Addition, B. Subtraction, C. Multiplication, D. Division, E. Modulus, F.Quit");
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.print("Enter a selection: ");
        opSymbol = sc.next().charAt(0);
        if(opSymbol == 'F') {
            System.out.print("Quit");
            System.exit(0);
        }

        System.out.print("Input 1st number: ");
        num1 = sc.nextInt();

        System.out.print("Input 2nd number: ");
        num2 = sc.nextInt();

        //process and output
        switch (opSymbol) {
            case 'A' :
                res = num1 + num2;
                System.out.print(num1 + " + " + num2 + " = " + res);
                break;
            case 'B' :
                res = num1 - num2;
                System.out.print(num1 + " - " + num2 + " = " + res);
                break;
            case 'C' :
                res = num1 * num2;
                System.out.print(num1 + " * " + num2 + " = " + res);
                break;
            case 'D' :
                if(num2 <= 0 ) {
                    System.out.print("Cannot divide by zero!");
                    return;
                }else {
                    res = num1 / num2;
                    System.out.print(num1 + " / " + num2 + " = " + res);
                    break;
                }
            case 'E' :
                res = num1 % num2;
                System.out.print(num1 + " % " + num2 + " = " + res);
                break;
            default:
                System.out.print("Invalid output, please choose a letter from the list provided!");
        }
    }
}
