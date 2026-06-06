import java.util.Scanner;

public class CableCompanyBilling {

    static void receiptOut(int accountNum, String accountType, int numberOfChannels) {

        double billProcFee, serviceFee, premiumChannels;

        if(accountType.equalsIgnoreCase("R")) {

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your account number: ");
        int accountNum = sc.nextInt();

        System.out.print("Please enter your customer code (R for residential or B for business customer): ");
        String accountType = sc.next();

        System.out.print("Please input number of channels: ");
        int numberOfChannels = sc.nextInt();

        receiptOut(accountNum , accountType, numberOfChannels);
    }
}
