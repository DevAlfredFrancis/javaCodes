/*  Name: Alfred Francis Ramos
    Year and Section: 2 - Discrete Structures 2
    Program Name: Pascal's Triangle ( Midterm Exam ) 
*/

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int userInput;
        
        //exit the loop if user input a valid number
        while(true) { 
            System.out.println("Enter the desired N of Pascal's triangle. ");
            System.out.print("Please input number from 1 - 100: ");
            userInput = sc.nextInt();
            
            if(userInput >= 1 && userInput <= 100) {
                System.out.println("Here's your Pascal's Triangle:");
                break;
            }else {
                System.out.println("Invalid input!");
            }
        }

        int[][] pascalTriangle = new int[userInput][userInput];

        for(int i=0; i<userInput; i++ ) {
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    pascalTriangle[i][j] = 1;
                }else {
                    pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
                }
            }
            System.out.printf("%" + (userInput - i) * 2 + "s","");
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", pascalTriangle[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}