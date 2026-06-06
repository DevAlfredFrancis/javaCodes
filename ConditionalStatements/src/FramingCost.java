/** 0.10 per inches cost coloring the frame, 0.15 per inch regular frame, 0.25 cost of fancy frame
 putting cardboard behind the picture is 0.02 per square inch,
 putting glass on top of the picture  is 0.07
 cx can choose to put crowns on the corners, which costs 0.35 per crown
 a. the length and width , in inches of the pictures
 b. the type of the frame
 c. customer's choice of color to color the frame
 d. if the user wants to add the crowns, then the numbers of crowns **/

import java.util.Scanner;

public class FramingCost {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter length (inches): ");
        double picLength = sc.nextDouble();

        System.out.print("Please enter width (inches): ");
        double picWidth = sc.nextDouble();

        String frameType = "";

        while (true) {
            System.out.print("Select your frame (regular or fancy): ");
            frameType = sc.next();

            if(frameType.equalsIgnoreCase("regular") || frameType.equalsIgnoreCase("fancy")) {
                break;
            }else {
                System.out.println("Invalid choice. Please select between regular or fancy only.");
            }
        }

        String colorChoice = "";
        double frameColorVal = 0;

        while (true) {
            System.out.print("Do you want to color the frame? Yes or No? ");
            colorChoice = sc.next();

            if(colorChoice.equalsIgnoreCase("Yes")) {
                frameColorVal = 0.10;
                break;
            }else if(colorChoice.equalsIgnoreCase("No")) {
                frameColorVal = 0;
                break;
            }
            else {
                System.out.println("Invalid choice. Please choose Yes or No only.");
            }
        }

        boolean validateAddCrown = true; //validate crown, to exit inner while loop
        int numCrown = 0;

        while (validateAddCrown) {
            System.out.print("Do you want to add crowns? Yes or No?");
            String addCrown = sc.next();

            if(addCrown.equalsIgnoreCase("Yes")) {
                while (true) {
                    System.out.print("How many crowns do you want to add? (1-4)");
                    numCrown = sc.nextInt();
                    if(numCrown > 0 && numCrown <= 4) {
                        validateAddCrown = false;
                       break;
                    }else {
                        System.out.println("Please add 1 to 4 pieces only.");
                    }
                }
            }else if(addCrown.equalsIgnoreCase("No")) {
                System.out.println("Crowns not added.");
                break;
            }else {
                System.out.println("Invalid choice. Please choose Yes or No only.");
            }
        }

        squareInch(picLength, picWidth, frameType, frameColorVal, numCrown);
    }

    static void squareInch(double picLength, double picWidth,String frameType, double frameColorVal, int numCrown) {
        final double regularFrame = 0.15;
        final double fancyFrame = 0.25;
        final double cardboardInFrame = 0.02;
        final double glassInFrame = 0.07;
        final double pricePerCrown = 0.35;

        double framePerimeter = picLength * picWidth;
        double glassPrice = glassInFrame * framePerimeter;
        double cardBoardPrice = cardboardInFrame * framePerimeter;
        double coloringFramePrice = frameColorVal * framePerimeter;
        double totalCrownPrice = numCrown * pricePerCrown;

        if(frameType.equalsIgnoreCase("regular")) {
            double regularPrice =  regularFrame * framePerimeter;
            double totalPrice = regularPrice + coloringFramePrice + totalCrownPrice + glassPrice + cardBoardPrice;

            System.out.println("----------------------- RECEIPT -----------------------");
            System.out.println("Total Frame Perimeter " + framePerimeter);
            System.out.println("Regular Frame Total Price: " + "$" + String.format("%.2f" , regularPrice));
            System.out.println("Coloring Frame Total Price: " + "$" + String.format("%.2f" , coloringFramePrice));
            System.out.println("Total Crown Price: " + "$" + String.format("%.2f" , totalCrownPrice));
            System.out.println("Total Price: " + "$" + String.format("%.2f" , totalPrice));
        }else {
            double fancyFramePrice =  fancyFrame * framePerimeter;
            double totalPrice = fancyFramePrice + coloringFramePrice + totalCrownPrice + glassPrice + cardBoardPrice;

            System.out.println("----------------------- RECEIPT -----------------------");
            System.out.println("Total Frame Perimeter " + String.format("%.2f" , framePerimeter));
            System.out.println("Fancy Frame Total Price: " + "$" + String.format("%.2f" , fancyFramePrice));
            System.out.println("Coloring Frame Total Price: " + "$" + String.format("%.2f" , coloringFramePrice));
            System.out.println("Total Crown Price: " + "$" + String.format("%.2f" , totalCrownPrice));
            System.out.println("Total Price: " + "$" + String.format("%.2f" , totalPrice));
        }
    }
}

