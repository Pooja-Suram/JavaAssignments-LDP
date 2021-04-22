import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoOfExceptions {

    HashMap<String, ArrayList<String>> studentDetails;

    public DemoOfExceptions(){
        studentDetails = new HashMap<String, ArrayList<String>>();
    }


    //Adding student details to studentDetails map
    public void addStudents(){

        //Printing this student details should throw StudentIDNotFoundException
        ArrayList<String> studentRam = new ArrayList<String>();
        studentRam.add("0");
        studentRam.add("10.0");
        studentDetails.put("Ram", studentRam);

        //Printing this student details should throw StudentIDNotFoundException
        ArrayList<String> studentRavi = new ArrayList<String>();
        studentRavi.add("180");
        studentRavi.add("0.0");
        studentDetails.put("Ravi", studentRavi);

        ArrayList<String> studentRoy = new ArrayList<String>();
        studentRoy.add("250");
        studentRoy.add("10.0");
        studentDetails.put("Roy", studentRoy);


        studentDetails.put("Amy", null);
    }



    public void printStudentDetails(){
        for(String name: studentDetails.keySet()){
            try{
                eachStudentDetails(name);
            }
            catch (Exception | StudentGradeNotFoundException ex){
                System.out.println(ex);
            }

            //This block is executed always
            finally {
                System.out.println("-------Finally Clause--------");
            }
        }
    }


    //This method prints each student details
    public void eachStudentDetails(String name) throws StudentNotFoundException,
            StudentIDNotFoundException, StudentGradeNotFoundException {

        //If student name is found, this block will execute
        //else StudentNotFoundException is thrown
        if(studentDetails.containsKey(name)){
            ArrayList<String> student = studentDetails.get(name);

            //If student ID is 0, StudentIDNotFoundException is thrown
            if(student.get(0).equals("0")){
                throw new StudentIDNotFoundException("Invalid Student details. ID cannot be 0");
            }

            //If student Grade is 0, StudentGradeNotFoundException is thrown
            else if(student.get(1).equals("0.0")){
                throw new StudentGradeNotFoundException("Invalid Student details. Garde cannot be 0.0");
            }

            //If all student details are correct, this block will be executed
            else{
                System.out.println("Student details are: \nName: " + name
                        + ", ID: " + student.get(0) + ", Grade: " + student.get(1));
            }
        }
        else{
            throw new StudentNotFoundException("Could not find student with name Ram");
        }
    }



    public static void main(String[] args) throws StudentGradeNotFoundException, StudentIDNotFoundException, StudentNotFoundException {
        DemoOfExceptions demo = new DemoOfExceptions();
        demo.addStudents();
        demo.printStudentDetails();
    }
}