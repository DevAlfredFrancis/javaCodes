import java.util.Scanner;

public class CallCost{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants
        final double RATE_PER_MINUTE = 7.00;
        final double TAX_RATE = 0.06;
        final double NIGHT_DISCOUNT = 0.40;
        final double LONG_CALL_DISCOUNT = 0.17;
        final int NIGHT_START = 1900; // 7:00 PM
        final int NIGHT_END = 800;    // 8:00 AM
        final int MAX_CALL_LENGTH = 60; // 60 minutes

        // Input
        System.out.print("Enter the start time of the call (HHMM format): ");
        int startTime = scanner.nextInt();
        System.out.print("Enter the length of the call in minutes: ");
        int callLength = scanner.nextInt();

        // Calculate gross cost
        double grossCost = callLength * RATE_PER_MINUTE;
        System.out.printf("Gross cost: P%.2f%n", grossCost);

        // Determine discounts based on time
        double discount = 0.0;

        // Check time for discounts
        if ((startTime >= NIGHT_START) || (startTime < NIGHT_END)) {
            discount += NIGHT_DISCOUNT; // 40% discount for night calls
        }

        // Apply length discount
        if (callLength > MAX_CALL_LENGTH) {
            discount += LONG_CALL_DISCOUNT; // 17% discount for long calls
        }

        // Calculate net cost after discounts
        double discountedCost = grossCost * (1 - discount);

        // Calculate tax
        double tax = discountedCost * TAX_RATE;
        double netCost = discountedCost + tax;

        // Output net cost
        System.out.printf("Net cost: P%.2f%n", netCost);

        scanner.close();
    }
}