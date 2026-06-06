import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {

        double quizGrade, activityGrade, examGrade;
        int passedCounter = 0, failedCounter = 0;

        while(true) {
            FileWriter fWriter = new FileWriter("studentRecord.txt",true);
            PrintWriter outputFile = new PrintWriter(fWriter);
            Scanner userInput = new Scanner(System.in);

            System.out.print("Enter your Name: ");
            String name = userInput.next();
            outputFile.print(name + ",");

            while(true) { // loop if user input invalid quiz grade
                System.out.print("Input your quiz grade: ");
                quizGrade = userInput.nextInt();

                if(quizGrade>=60 && quizGrade<=100) { //append value to text file
                    outputFile.print(quizGrade + ",");
                    break;
                }else {
                    System.out.println("Invalid quiz grade! Please input a valid grade.");
                }
            }

            while(true) { // loop if user input invalid activity grade
                System.out.print("Input your activity grade: ");
                activityGrade = userInput.nextInt();

                if(activityGrade>=60 && activityGrade<=100) { //append value to text file
                    outputFile.print(activityGrade + ",");
                    break;
                }else {
                    System.out.println("Invalid activity grade! Please input a valid grade.");
                }
            }

            while(true) { // loop if user input invalid exam grade
                System.out.print("Input exam grade: ");
                examGrade = userInput.nextInt();

                if(examGrade>=60 && examGrade<=100) { //append value to text file
                    outputFile.print(examGrade + ",");
                    break;
                }else {
                    System.out.println("Invalid exam grade! Please input a valid grade.");
                }
            }

            StudentRecord studentGrades = new StudentRecord(); //create studentGrades object from StudentRecord Class
            double finalGrade = studentGrades.computeFinalGrade(quizGrade, activityGrade, examGrade); //call the method from StudentRecord Class
            outputFile.print(finalGrade + "\n"); //insert new line after the final grade

            if(finalGrade>=75 && finalGrade<=100) { //check for grades if Passed or Failed
                passedCounter++;
            }else {
                failedCounter++;
            }

            System.out.println("-------------------------------" );
            System.out.println("Number of Passed: " + passedCounter);
            System.out.println("Number of Failed: " + failedCounter);
            System.out.println("-------------------------------" );

            outputFile.close(); //close the file

            System.out.print("Do you want to enter again? (Yes or No): ");
            String logAgain = userInput.next();

            if(logAgain.equalsIgnoreCase("Yes")) {
                System.out.println("Please enter another data!");
            }else if(logAgain.equalsIgnoreCase("No")) {
                break;
            }else {
                System.out.print("Invalid response, Please type Yes or No only.");
                break;
            }
        }
    }
}