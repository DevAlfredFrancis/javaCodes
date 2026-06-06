/* 9. Ordered Number. A 4-digit number WXYZ is called an ordered number if the difference between the first two digits,
WX and the last two digits, YZ, WX-YZ =1 or YZ-WX =1. For example, 1213 and 4645 are ordered no.,
while 2346 and 7685 are not ordered numbers. Write a program that will accept a 4-digit number and will determine if it is an ordered */

import java.util.Scanner;

public class OrderedNumber2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a 4-digit number: ");
        String inputNum = sc.next(); //get input from user

        char[] charArr = inputNum.toCharArray(); //convert 4 digits to array of character

        String concatWX = "" + charArr[0] + charArr[1]; //concat 1st and 2nd digit
        String concatYZ = "" + charArr[2] + charArr[3]; //concat 3rd and 4th digit

        int convertedWX = Integer.parseInt(concatWX); //convert concatenated 1st and 2nd digit to integer
        int convertedYZ = Integer.parseInt(concatYZ); //convert concatenated 3rd and 4th digit to integer

        int res1 = convertedYZ - convertedWX;
        int res2 = convertedWX - convertedYZ;

        if(res1 == 1 || res2 == 1) {
            System.out.println("ordered number");
        }else {
            System.out.println("unordered number!");
        }

    }
}
