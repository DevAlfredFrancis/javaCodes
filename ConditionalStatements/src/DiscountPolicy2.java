import java.util.Scanner;

public class DiscountPolicy2 {

    static void printReceipt(double totalPurchase, String confirmMusicTeacher) {

        double totalDiscount, discountedTotal, salesTax, totalVal;

        if(totalPurchase >= 100 && confirmMusicTeacher.equalsIgnoreCase("yes")) { //12% discount if total purchase is 100 or higher, and customer is a music teacher
            totalDiscount = totalPurchase * 0.12;
            discountedTotal = totalPurchase - totalDiscount;
            salesTax = discountedTotal * 0.05;
            totalVal = discountedTotal + salesTax;

            System.out.println("-------------------------------------");
            System.out.println("Total Purchases:           " + "$" + String.format("%.2f" , totalPurchase));
            System.out.println("Total discount (12%):      " + "$" + String.format("%.2f" , totalDiscount));
            System.out.println("Discounted Total:          " + "$" + String.format("%.2f" , discountedTotal));
            System.out.println("Sales tax (5%):            " + "$" + String.format("%.2f" , salesTax));
            System.out.println("TOTAL:                     " + "$" + String.format("%.2f" , totalVal));
            System.out.println("-------------------------------------");
        }else if(totalPurchase < 100 && confirmMusicTeacher.equalsIgnoreCase("yes")) { //10% discount if total purchase is below 100, and customer is a music teacher
            totalDiscount = totalPurchase * 0.10;
            discountedTotal = totalPurchase - totalDiscount;
            salesTax = discountedTotal * 0.05;
            totalVal = discountedTotal + salesTax;

            System.out.println("-------------------------------------");
            System.out.println("Total Purchases:           " + "$" + String.format("%.2f" , totalPurchase));
            System.out.println("Total discount (10%):      " + "$" + String.format("%.2f" , totalDiscount));
            System.out.println("Discounted Total:          " + "$" + String.format("%.2f" , discountedTotal));
            System.out.println("Sales tax (5%):            " + "$" + String.format("%.2f" , salesTax));
            System.out.println("TOTAL:                     " + "$" + String.format("%.2f" , totalVal));
            System.out.println("-------------------------------------");
        }else if(confirmMusicTeacher.equalsIgnoreCase("yes") || confirmMusicTeacher.equalsIgnoreCase("no")){ //no discount, and validate user input
            salesTax = totalPurchase * 0.05;
            totalVal = totalPurchase + salesTax;

            System.out.println("-------------------------------------");
            System.out.println("Total Purchases:           " + "$" + String.format("%.2f" , totalPurchase));
            System.out.println("Sales tax (5%):            " + "$" + String.format("%.2f" , salesTax));
            System.out.println("TOTAL:                     " + "$" + String.format("%.2f" , totalVal));
            System.out.println("-------------------------------------");
        }else {
            System.out.println("Invalid input, please choose between yes or no! ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total purchase: ");
        double totalPurchase = sc.nextDouble();

        System.out.print("Are you a music teacher? (yes or no): ");
        String confirmMusicTeacher = sc.next();

        printReceipt(totalPurchase,confirmMusicTeacher);
    }
}
