import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static String sortField, sortType;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //display the menu
        System.out.println("Menu:");
        System.out.println("A. Name");
        System.out.println("B. Age");
        System.out.println("C. Job Role");
        System.out.println("D. Employment Status");
        System.out.println("E: Year Hired");

        while(true) {
            System.out.print("Select the field you want to sort: ");
            sortField = sc.next();
            if(sortField.matches("(?i)[A-E]")) {
                break;
            }else {
                System.out.println("Invalid Input!");
            }
        }

        while(true) {
            System.out.print("What type of sorting do you want? (A for ascending or D for descending) ");
            sortType = sc.next();
            if(sortType.matches("(?i)[AD]")) {
                break;
            }else {
                System.out.println("Invalid Input!");
            }
        }

        //read file into array
        String[][] employeeRecords = new String[100][];
        int recordCount = 0;

        try {
            File myFile = new File("employeesData.txt");
            Scanner inFile = new Scanner(myFile);

            while(inFile.hasNextLine() && recordCount < employeeRecords.length) {
                String line = inFile.nextLine();
                String[] employeeData = line.split(",");
                employeeRecords[recordCount] = employeeData;
                recordCount++;
            }

            int sortIndex = getSortIndex(sortField);

            //bubble sort on array
            for(int i=0; i< recordCount -1; i++) {
                for(int j=0; j<recordCount -1 - i; j++) {
                    String val1 = employeeRecords[j][sortIndex].trim();
                    String val2 = employeeRecords[j+1][sortIndex].trim();

                    int result;

                    if(sortIndex == 1 || sortIndex == 4) { //numeric fields, age or year hired
                        //parse the values as integers for comparison
                        int num1 = Integer.parseInt(val1);
                        int num2 = Integer.parseInt(val2);
                        result = Integer.compare(num1, num2);
                    }else {
                        result = val1.compareToIgnoreCase(val2);
                    }

                    //swap if the order is wrong
                    if((sortType.equalsIgnoreCase("A") && result > 0) || (sortType.equalsIgnoreCase("D") && result < 0)) {
                        //swap
                        String[] temp = employeeRecords[j];
                        employeeRecords[j] = employeeRecords[j+1];
                        employeeRecords[j+1] = temp;
                    }
                }
            }

            //display sorted records
            System.out.println("Sorted Records:");
            for(int i=0; i<recordCount; i++) {
                System.out.println(String.join(",",employeeRecords[i]));
            }

        } catch (FileNotFoundException e) {
            System.out.print("File not found!");
        }
    }

    static int getSortIndex(String sortField) {
        switch (sortField.toUpperCase()) {
            case "A":
            case "NAME":
                return 0;
            case "B":
            case "AGE":
                return 1;
            case "C":
            case "JOB ROLE":
                return 2;
            case "D":
            case "EMPLOYMENT STATUS":
                return 3;
            case "E":
            case "YEAR HIRED":
                return 4;
            default:
                return 0;
        }
    }

    static void displayRecord(String[] employeeData,String sortField, String sortType, int recordCount) {

        int index;
        // Determine which index to search
        switch (sortField.toUpperCase()) {
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

    }
}