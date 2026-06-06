/*
 Name: Alfred Francis Ramos 
 Date: Oct. 3, 2025
 Program name: Student Record Application
 */

public class StudentRecordApp {
    public static void main(String[] args) {
        
        Student studentRecord1 = new Student("Joselito Pepito", "BSEE", 23);
        double quizGrade = 89.5;
        double activityGrade = 90;
        double examGrade = 88;
        
        studentRecord1.computeFinalGrade(quizGrade, activityGrade, examGrade);
        studentRecord1.showStudentRecord();

        System.out.println("=====================================");

        Student studentRecord2 = new Student("Alfred Ramos","BSCS",28);
        quizGrade = 98;
        activityGrade = 98;
        examGrade = 95;
        
        studentRecord2.computeFinalGrade(quizGrade, activityGrade, examGrade);
        studentRecord2.setAddress("Naga City, C.S");
        studentRecord2.showStudentRecord();
        studentRecord2.showStudentAddress();

    }
   
}