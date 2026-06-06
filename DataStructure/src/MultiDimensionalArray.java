/**
 * Name: [Ramos, Alfred Francis P.]
 * Date: [January 31, 2025]
 * Section: [BCS122L-OCa] 3009
 */
import java.util.Scanner;

public class MultiDimensionalArray {

    public static void main(String[] args) {

        int[] arrNum = new int[10];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<arrNum.length; i++) {
            while(true) {
                System.out.print("Please input #"+ (i+1) + " :");
                int userInput = sc.nextInt();

                if(userInput>=10 && userInput<=99) {
                    arrNum[i] = userInput;
                    break;
                }else {
                    System.out.print("Invalid number! Please input number between 10 to 99");
                }
            }
        }

        System.out.print("Generated array of numbers: ");
        for(int i: arrNum) {
            System.out.print(i + ",");
        }

        System.out.println("\n------------------------------------------------------");

        for(int i=0; i<arrNum.length; i++) {
            if(arrNum[i]%4 == 0) {
                arrNum[i] = 40;
            }
        }

        System.out.print("Updated array of numbers:");
        for(int i: arrNum) {
            System.out.print(i + ",");
        }
    }
}