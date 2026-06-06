/**
 * Name: [Ramos, Alfred Francis P.]
 * Date: [February 2, 2025]
 * Section: [BCS123L-OCa (3011)]
 */

import java.io.*;
import java.util.Scanner;

public class DataManipulation {

    static double userGrade(double grade ) {
        if(grade>=60 && grade<=100) { //append value to the text file
            return  grade;
        }else {
            System.out.println("Invalid quiz grade! Please input a valid grade.");
            return grade;
        }
    }

    public static void main(String[] args)throws IOException {

        while(true) {
            double quizGrade, activityGrade, examGrade; //declaring data type and variable

            FileWriter fWriter = new FileWriter("studentRecord.txt",true); //Append data to a file, if the file does not exist, it will be created
            PrintWriter outputFile = new PrintWriter(fWriter); //PrintWriter object to print and println methods to write data to the file

            Scanner userInput = new Scanner(System.in);

            System.out.print("Enter your Name: ");
            String name = userInput.nextLine();

            while(true) { // loop if user input invalid grade
                System.out.print("Enter your quiz grade: ");
                quizGrade = userInput.nextDouble();

                if(quizGrade>=60 && quizGrade<=100) { //append value to the text file
                    break;
                }else {
                    System.out.println("Invalid quiz grade! Please input a valid grade.");
                }
            }





            while(true) { // loop if user input invalid grade
                System.out.print("Enter your quiz grade: ");
                quizGrade = userInput.nextDouble();

                if(quizGrade>=60 && quizGrade<=100) { //append value to the text file
                    break;
                }else {
                    System.out.println("Invalid quiz grade! Please input a valid grade.");
                }
            }

            while(true) { // loop if user input invalid grade
                System.out.print("Enter your activity grade: ");
                activityGrade = userInput.nextDouble();

                if(activityGrade>=60 && activityGrade<=100) { //append value to the text file
                    break;
                }else {
                    System.out.println("Invalid activity grade! Please input a valid grade.");
                }
            }

            while(true) { // loop if user input invalid grade
                System.out.print("Enter your exam grade: ");
                examGrade = userInput.nextDouble();

                if(examGrade>=60 && examGrade<=100) { //append value to the text file
                    break;
                }else {
                    System.out.println("Invalid exam grade! Please input a valid grade.");
                }
            }

            double finalGrade = (quizGrade * 0.3) + (activityGrade * 0.3) + (examGrade * 0.4);
            outputFile.println(name + "," + quizGrade + "," + activityGrade + "," + examGrade + "," +  finalGrade); //insert new line after appending the data

            outputFile.close(); //close the file

            File myFile = new File("studentRecord.txt"); // read data from a file
            Scanner inputFile = new Scanner(myFile);
            String line; //data per line
            int passedCounter = 0;
            int failedCounter = 0;

            while (inputFile.hasNextLine()) { //reads all the line of input from a text file
                line = inputFile.nextLine();
                String[] token = line.split(",");
                String strFinalGrade = token[4];
                double convertStrFinalGrade = Double.parseDouble(strFinalGrade);

                if(convertStrFinalGrade>=75 && convertStrFinalGrade<=100) { //check for grades if Passed or Failed
                    passedCounter++;
                }else {
                    failedCounter++;
                }
            }

            System.out.println("-------------------------------" );
            System.out.println("Number of Passed: " + passedCounter);
            System.out.println("Number of Failed: " + failedCounter);
            System.out.println("-------------------------------" );

            inputFile.close(); //close the file

            System.out.print("Do you want to enter again? (Yes or No): ");
            String logDataAgain = userInput.next();

            if(logDataAgain.equalsIgnoreCase("Yes")) { //user validation if the user wants to enter another data
                System.out.println("Please enter another data!");
            }else if(logDataAgain.equalsIgnoreCase("No")) {
                break;
            }else {
                System.out.print("Invalid response, Please type Yes or No only.");
                break;
            }
        }
    }
}