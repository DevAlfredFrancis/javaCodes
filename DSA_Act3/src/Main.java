import java.util.Scanner;
import java.io.*;

public class Main {

    //declare global variables
    static boolean isFound = false;
    static int count = 0;
    static String searchCategory, searchText;

    //create a method to display employees data based on search
    static void displayRecord(String[] employeesData, String searchCategory, String searchText) {
        int index;

        // Determine which index to search
        switch (searchCategory.toUpperCase()) {
            case "A":
            case "NAME":
                index = 0;
                break;
            case "B":
            case "AGE":
                index = 1;
                break;
            case "C":
            case "JOB ROLE":
                index = 2;
                break;
            case "D":
            case "EMPLOYMENT STATUS":
                index = 3;
                break;
            case "E":
            case "YEAR HIRED":
                index = 4;
                break;
            default:
                System.out.println("Invalid category selected.");
                return;
        }

        // Check if the specific field matches the searchText
        if (index < employeesData.length && searchText.equalsIgnoreCase(employeesData[index])) {
            System.out.println("------------------------------------- ");
            System.out.println("Name: " + employeesData[0]);
            System.out.println("Age: " + employeesData[1]);
            System.out.println("Job Role: " + employeesData[2]);
            System.out.println("Employment Status: " + employeesData[3]);
            System.out.println("Year Hired: " + employeesData[4]);
            isFound = true;
            count++;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        File myFile = new File("users.txt"); //open the text file
        Scanner inputFile = new Scanner(myFile); //scan or read the data from the text file

        //display the menu
        System.out.println("Menu:");
        System.out.println("A. Name");
        System.out.println("B. Age");
        System.out.println("C. Job Role");
        System.out.println("D. Employment Status");
        System.out.println("E. Year Hired");
        System.out.println("F. Exit");

        //get user input
        while(true) {
            System.out.print("Select the field you want to search: ");
            searchCategory = sc.next();

            if(searchCategory.equalsIgnoreCase("A") || searchCategory.equalsIgnoreCase("B") || searchCategory.equalsIgnoreCase("C") || searchCategory.equalsIgnoreCase("D") || searchCategory.equalsIgnoreCase("E")) {
                break;
            }else if (searchCategory.equalsIgnoreCase("F")) {
                System.out.println("Exiting....");
                System.exit(0);
            }else {
                System.out.println("Invalid Input!");
            }
        }

        //clear the newline character from buffer before nextLine()
        sc.nextLine();

        System.out.print("Enter the text you want to search: ");
        searchText = sc.nextLine();

        //read all the data until the end of file
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine(); //store data per line to a variable
            String[] employeesData = line.split(","); //convert the data to array using the split method

            //display record based on user input
            displayRecord(employeesData, searchCategory, searchText);
        }

        //display total counts
        System.out.println("------------------------------------- ");
        System.out.println("Total Records: " + count);

        //display not found, if user input did not matched on our data
        if (!isFound) {
            System.out.println("No Record Found!");
        }

        inputFile.close(); // Close the file to free resources
        sc.close(); //close the scanner
    }
}
