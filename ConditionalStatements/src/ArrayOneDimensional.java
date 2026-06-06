/**
 * Name: [Ramos, Alfred Francis P.]
 * Date: [January 22, 2025]
 * Section: [BCS123L-OCa]
 */

public class ArrayOneDimensional {

    public static void main(String[] args) {

        int[] arrNum = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,20};

        for (int i : arrNum) {
            if (i % 2 == 0) {
                System.out.println(i + " is Even Number");
            } else {
                System.out.println(i + " is Odd Number");
            }
        }
    }
}
