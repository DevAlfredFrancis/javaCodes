import java.util.Scanner;

public class BinaryCalculator {

    String firstBinary, secondBinary, result;
    int binaryOperation;
    Scanner sc = new Scanner(System.in);

    //constructor
    public BinaryCalculator() {

        while (true) {
            try {
                System.out.print("Input your 1st binary: ");
                firstBinary = sc.nextLine().trim();

                //validate if input contains only 0 or 1
                if (!firstBinary.matches("[01]+")) {
                    throw new NumberFormatException("Not a valid binary number!");
                }
                break; // input is valid → exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid binary number (only 0s and 1s).");
            }
            
        }

        while (true) {
            try {
                System.out.print("Input your 2nd binary: ");
                secondBinary = sc.nextLine().trim();

                //validate if input contains only 0 or 1
                if (!secondBinary.matches("[01]+")) {
                    throw new NumberFormatException("Not a valid binary number!");
                }
                break; // input is valid → exit loop
            } catch (NumberFormatException  e) {
                System.out.println("Invalid input! Please enter a valid binary number (only 0s and 1s).");
            }
            
        }

        while (true) {
            try {
                System.out.println("Choose your operator:");
                System.out.println("1. Add binary");
                System.out.println("2. Subtract binary");
                System.out.println("3. Multiply binary");
                System.out.println("4. Divide binary");
                System.out.print("Enter choice (1-4): ");

                binaryOperation = sc.nextInt();

                // Validate operator range
                if (binaryOperation < 1 || binaryOperation > 4) {
                    throw new NumberFormatException("Invalid operator choice!");
                }

                break; // Valid input, exit loop
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Please choose between 1 and 4.");
                sc.nextLine(); 
            } 
            catch (Exception e) {
                System.out.println("Please enter a number only.");
                sc.nextLine(); // clear invalid input
            }
        }

        switch (binaryOperation) {
            case 1 :
                calculate( firstBinary,  secondBinary,  binaryOperation);
                break;
            case 2 :
                SubtractBinary.calculate(firstBinary, secondBinary, binaryOperation);
                break;
            case 3 :
                MultiplyBinary.calculate(firstBinary, secondBinary, binaryOperation);
                break;
            case 4 :
                DivideBinary.calculate(firstBinary, secondBinary, binaryOperation);
                break;
            default:
                System.out.println("Invalid operation!");
        }     
    }

    public static void calculate(String firstBinary, String secondBinary, int binaryOperation) {
        long sum = Long.parseLong(firstBinary,2) + Long.parseLong(secondBinary,2);
        String result = Long.toBinaryString(sum);

        System.out.println("Result : " + result);
    }
}

class SubtractBinary extends BinaryCalculator {
    
    public static void calculate(String firstBinary, String secondBinary, int binaryOperation) {
        long diff = Long.parseLong(firstBinary,2) - Long.parseLong(secondBinary,2);
        String result = Long.toBinaryString(diff);

        System.out.println("Result : " + result);
    }
}

class MultiplyBinary extends BinaryCalculator {
    
    public static void calculate(String firstBinary, String secondBinary, int binaryOperation) {
        long product = Long.parseLong(firstBinary,2) * Long.parseLong(secondBinary,2);
        String result = Long.toBinaryString(product);

        System.out.println("Result : " + result);
    }
}

class DivideBinary extends BinaryCalculator {
    
    public static void calculate(String firstBinary, String secondBinary, int binaryOperation) {
        long product = Long.parseLong(firstBinary,2) / Long.parseLong(secondBinary,2);
        String result = Long.toBinaryString(product);

        System.out.println("Result : " + result);
    }
}