import java.util.Scanner;
import java.util.ArrayList;

public class Ramos_PostClassArrayList03 {

    public static void main(String[] args) {

        double userInput;
        ArrayList<Double> listOfNum = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true) { //loop until the user want to exit the program
            System.out.println("Enter 0 or more to put in the list or -1 to exit: ");
            userInput = sc.nextDouble();
            if(userInput >= 0) {
                listOfNum.add(userInput);
            }else {
                break;
            }
        }

        for(int i=listOfNum.size()-1; i >= 0; i--) { //loop in the arraylist backward
            System.out.println(listOfNum.get(i));
        }
    }
}