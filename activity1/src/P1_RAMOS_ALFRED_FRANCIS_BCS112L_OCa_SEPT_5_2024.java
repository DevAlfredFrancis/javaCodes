/**
 * Name: [Ramos, Alfred Francis P.]
 * Date: [September 5, 2024]
 * Section: [BCS112L-OCa]
 */

import java.util.Scanner;

public class P1_RAMOS_ALFRED_FRANCIS_BCS112L_OCa_SEPT_5_2024 {

    public static void main(String[] args) {

        //declaring variables and data types (input section)
        double radCircle;
        double areaCircle;
        double circumferenceCircle;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius:");
        radCircle = sc.nextDouble();

        //process section
        areaCircle = Math.PI * (radCircle * radCircle);
        circumferenceCircle = 2 * Math.PI * radCircle;

        //output section
        System.out.println("Area of circle: " + areaCircle);
        System.out.println("Circumference of circle: " + circumferenceCircle);

    }
}