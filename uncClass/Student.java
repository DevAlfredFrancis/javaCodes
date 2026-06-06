public class Student {
    private String studentName, course, address;
    private int age;
    private static double finalGrade;

    //constructor
    public Student(String studentName,  String course, int age) {
        this.studentName = studentName;
        this.course = course;
        this.age = age;
    }

    //getter
    public String getAddress() { return address; }

    //setter
    public String setAddress(String address) { return  this.address = address; }

    //show student record
    public void showStudentRecord() {
        System.out.println("Student name: " + this.studentName );
        System.out.println("Student course: " + this.course );
        System.out.println("Student age: " + this.age);
        System.out.println("Student final grade: " + finalGrade);
    }

    //method to compute final grade
    public double computeFinalGrade(double quizGrade, double activityGrade, double examGrade) {
        finalGrade = (quizGrade * 0.3) + (activityGrade * 0.3) + (examGrade * 0.4);
        return finalGrade;
    }

    //method to show student address
    public void showStudentAddress() {
        System.out.println("Student address: " + address);
    }

    @Override   
    public String toString() {
        return "Student name: " + this.studentName + "\nStudent course: " + this.age + "\nStudent age: ";
    }


}
