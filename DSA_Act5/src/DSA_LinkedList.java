import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class DSA_LinkedList {

    //declaration of static variables to be used in methods
    static LinkedList<String> records = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static String userInput, searchByName;
    static String employeesName, employeesRole;
    static int employeesAge;

    public static void main(String[] args) {

        // call readEmployeeData method, read data from text file then pass it to linked list
        readEmployeeData();

        //loop the program until the user decided to exit or end the program
        while(true) {
            displayMenu(); //call the displayMenu method

            while(true) { //user input validation, keep on looping until the correct response has been provided
                System.out.print("Input your choice: ");
                userInput = sc.next();
                if(userInput.matches("(?i)[A-H]")) { //shorter code using regex, not case-sensitive from A to H
                    break;
                }else {
                    System.out.println("Invalid input, Please select Letter from the menu!");
                }
            }

            if(userInput.equalsIgnoreCase("H")) { //exit the program
                System.out.print("Exiting....");
                sc.close();
                System.exit(0);
            }else {
                selectMethod(userInput);
            }
        }
    }

    //display program menu
    static void displayMenu() {
        System.out.println("-----------Menu-----------");
        System.out.println("A. Add Record to First");
        System.out.println("B. Add Record to Last");
        System.out.println("C. Remove First Record");
        System.out.println("D. Remove Last Record");
        System.out.println("E. Display All Record");
        System.out.println("F. Display Specific Record");
        System.out.println("G. Edit Record");
        System.out.println("H. Exit");
        System.out.println("-------------------------");
    }

    //method selection based on user input
    static void selectMethod(String userInput) {
        switch (userInput) {
            case "A" :
            case "a" :
                addRecordToFirst();
                break;
            case "B" :
            case "b" :
                addRecordToLast();
                break;
            case "C" :
            case "c" :
                removeFirstRecord();
                break;
            case "D" :
            case "d" :
                removeLastRecord();
                break;
            case "E" :
            case "e" :
                displayAllRecords();
                break;
            case "F" :
            case "f" :
                displaySpecificRecords();
                break;
            case "G" :
            case "g" :
                editRecord();
                break;
            default:
                System.out.print("Invalid choice!");
        }
    }

    //read all records from the text file
    static void readEmployeeData() {
        File file = new File("employeesData.txt");

        if(!file.exists()) {
            System.out.print("File not found!");
        }

        //read data from txt file then add it to linked list
        try(Scanner fileReader = new Scanner(file)) {
            while(fileReader.hasNextLine()) {
                records.add(fileReader.nextLine());
            }
        }catch (Exception e) {
            System.out.println("Error reading the file!");
        }
    }

    //add record to first
    static void addRecordToFirst() {
        while (true) { // name validation, exit loop once input a valid data
            System.out.print("Please input a name (letters only): ");
            employeesName = sc.nextLine();
            if (isLettersOnly(employeesName)) {
                break; // valid input, exit loop
            }else {
                System.out.println("Invalid input! Please enter letters only.");
            }
        }

        while(true) { // age validation, exit loop once input a valid data
            System.out.print("Please input age: ");
            if(sc.hasNextInt()) {
                employeesAge = sc.nextInt();
                sc.nextLine();
                break;
            }else {
                System.out.println("Invalid input!");
                sc.next();
            }
        }

        while(true) { // role validation, exit loop once input a valid data
            System.out.print("Please input a role: ");
            if(sc.hasNextLine()) {
                employeesRole = sc.nextLine();
                break;
            }else {
                System.out.println("Invalid input!");
                sc.next();
            }
        }

        // add new record to the first of the list
        String newRecord = employeesName + "," + employeesAge + "," + employeesRole;
        records.addFirst(newRecord);

        //update list to text file
        updateRecordsToFile();
    }

    //add record to last
    static void addRecordToLast() {
        while (true) { // name validation, exit loop once input a valid data
            System.out.print("Please input a name (letters only): ");
            employeesName = sc.nextLine();
            if (isLettersOnly(employeesName)) {
                break; // valid input, exit loop
            }else {
                System.out.println("Invalid input! Please enter letters only.");
            }
        }

        while(true) { // age validation, exit loop once input a valid data
            System.out.print("Please input age: ");
            if(sc.hasNextInt()) {
                employeesAge = sc.nextInt();
                sc.nextLine();
                break;
            }else {
                System.out.println("Invalid input!");
                sc.next();
            }
        }

        while(true) { // role validation, exit loop once input a valid data
            System.out.print("Please input a role: ");
            if(sc.hasNextLine()) {
                employeesRole = sc.nextLine();
                break;
            }else {
                System.out.println("Invalid input!");
                sc.next();
            }
        }

        // add new record to the last of the list
        String newRecord = employeesName + "," + employeesAge + "," + employeesRole;
        records.addLast(newRecord);

        //update list to text file
        updateRecordsToFile();
    }

    //update text file from linked list data
    static void updateRecordsToFile() {
        try (FileWriter writer = new FileWriter("employeesData.txt")) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Record updated!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    //remove first record
    static void removeFirstRecord() {
        //validation only, if records is empty
        if (records.isEmpty()) {
            System.out.println("No records to remove.");
            return;
        }

        //remove the first record
        String removed = records.removeFirst();
        System.out.println("Removed first record: " + removed);

        //update list to text file
        updateRecordsToFile();
    }

    //remove last record
    static void removeLastRecord() {
        //validation only, if records is empty
        if (records.isEmpty()) {
            System.out.println("No records to remove.");
            return;
        }

        //remove the last record
        String removed = records.removeLast();
        System.out.println("Removed last record: " + removed);

        //update list to text file
        updateRecordsToFile();
    }

    //display all records
    static void displayAllRecords() {
        //validation only, if records is empty
        if(records.isEmpty()) {
            System.out.println("No record found!");
        }

        //display all records using for-each loop
        for(String record : records) {
            System.out.println(record);
        }
    }

    //display all records
    static void displaySpecificRecords() {
        //ask the user to search specific record by name
        System.out.print("Search specific record by name: ");
        searchByName = sc.next().toLowerCase();
        boolean isFound = false;

        //display the record, based on user input
        for(String record : records) {
            if(record.toLowerCase().contains(searchByName)) {
                System.out.println("Found: " + record);
                isFound = true;
            }
        }

        //display if record not found
        if(!isFound) {
            System.out.println("Record not found!");
        }
    }

    //edit record
    static void editRecord() {
        //ask the user for specific record to edit by name
        System.out.print("Enter name of the record to edit: ");
        String editByName = sc.next().toLowerCase();
        sc.nextLine();
        boolean isFound = false;

        //using for loop, update the record based in index
        for(int i=0; i<records.size(); i++) {
            if(records.get(i).toLowerCase().contains(editByName)) {
                isFound = true;

                while (true) { // name validation, exit loop once input a valid data
                    System.out.print("Please input a name (letters only): ");
                    employeesName = sc.nextLine();
                    if (isLettersOnly(employeesName)) {
                        break; // valid input, exit loop
                    }else {
                        System.out.println("Invalid input! Please enter letters only.");
                    }
                }

                while(true) { // age validation, exit loop once input a valid data
                    System.out.print("Please input age: ");
                    if(sc.hasNextInt()) {
                        employeesAge = sc.nextInt();
                        sc.nextLine();
                        break;
                    }else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                }

                while(true) { // role validation, exit loop once input a valid data
                    System.out.print("Please input a role: ");
                    if(sc.hasNextLine()) {
                        employeesRole = sc.nextLine();
                        break;
                    }else {
                        System.out.println("Invalid input!");
                        sc.next();
                    }
                }

                // update record based on user input and index of the record
                String newRecord = employeesName + "," + employeesAge + "," + employeesRole;
                records.set(i,newRecord);

                //update list to text file
                updateRecordsToFile();
            }
        }

        //display if record not found
        if(!isFound) {
            System.out.println("Record not found!");
        }
    }

    //input validation, preventing user to input numbers in Names
    static boolean isLettersOnly(String input) {
        if (input.isEmpty()) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false; // found a non-letter and non-space char
            }
        }
        return true; // all letters or spaces
    }
}