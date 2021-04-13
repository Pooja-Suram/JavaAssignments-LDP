import java.util.*;
import java.util.stream.Collectors;

public class StudentDetails {

    List<Student> studentsList;

    public StudentDetails(){
        studentsList = new ArrayList<Student>();
    }


    //Entering all student details into list
    public void enterDetails(){
        studentsList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentsList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentsList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentsList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentsList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentsList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentsList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentsList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentsList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentsList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentsList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentsList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentsList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentsList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentsList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentsList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentsList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
    }



    //Question 1: Name of all departments
    public void printAllDepartments(){
        System.out.println("\n Departments are:");
        Set<String> departmentList = studentsList.stream()
                .map(student -> student.getEngDepartment()).collect(Collectors.toSet());
        System.out.println(departmentList);
    }



    //Question 2: Names of all students enrolled after given year
    public void getStudentsEnrolledAfterYear(int year){

        List<String> studentNames = studentsList.stream()
                .filter(student -> student.getYearOfEnrollment() > year)
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println("\nStudents enrolled after "+ year + " are:");
        System.out.println(studentNames);
    }



    //Question 3: Details of male students in Computer Sci Department
    public void getStudentForGivenGenderGivenDepartment(String gender, String department){

        System.out.println("\nStudent details whose gender is "+ gender + " and department is " + department + " :");

        studentsList.stream()
                .filter(student -> student.getGender().equals(gender) && student.getEngDepartment().equals(department))
                .forEach(student -> student.printDetails());
    }



    //Question 4: Number of Male and female students using groupingBy
    public void getNumberOfFemaleMale(){
        System.out.println("\nNumber of students per gender are: ");
        Map<Object, Long> perGenderCount = studentsList.stream()
                .collect(Collectors.groupingBy(student -> student.getGender(), Collectors.counting()));
        System.out.println(perGenderCount);
    }



    //Question 5: Average age of male and female students
    public void getAverageAge(){
        double sumOfAges = studentsList.stream().mapToDouble(student -> student.getAge()).sum();
        System.out.println("\nAverage age of male and female students is: "+Math.round(sumOfAges/studentsList.size()));
    }



    //Question 6: Details of student having Highest Percentage
    public void getStudentWithHighestPercentage(){
        Student student = studentsList.stream()
                .max((student1, student2) -> student1.getPerTillDate() > student2.getPerTillDate()?1:-1).get();
        System.out.println("\nDetails of student with high percentage are: ");
        student.printDetails();
    }



    //Question 7: Count of students in each department
    public void getStudentsPerEachDepartment(){
        System.out.println("\nNumber of students in each department are : ");
        Map<Object, Long> perDeptCount = studentsList.stream()
                .collect(Collectors.groupingBy(student -> student.getEngDepartment(), Collectors.counting()));
        System.out.println(perDeptCount);
    }



    //Question 8: Average percentage achieved in each department
    public void getAveragePerDepartment(){
        Map<Object, Double> perDeptAvg= studentsList.stream()
                .collect(Collectors.groupingBy(student -> student.getEngDepartment(),
                        Collectors.averagingDouble(student -> student.getPerTillDate())));
        System.out.println("\nPer Department average of percentages are  :");
        System.out.println(perDeptAvg);
    }



    //Question 9: Youngest male student in given department
    public void getYoungestMaleInGivenDept(String department){
        Student student = studentsList.stream()
                .filter(student1 -> student1.getEngDepartment().equals(department) && student1.getGender().equals("Male"))
                .min(Comparator.comparingInt(student1 -> student1.getAge())).get();
        System.out.println("\nYoungest Male student in " + department +" department is: ");
        student.printDetails();
    }



    //Question 10: Number of male and female students in given dept
    public void getNumberOfFemaleMaleInGivenDept(String department){
        Map<Object, Long> perGenderCount = studentsList.stream()
                .filter(student -> student.getEngDepartment().equals(department))
                .collect(Collectors.groupingBy(student -> student.getGender(), Collectors.counting()));
        System.out.println("\nNUmber of male and female in " + department + " department are: ");
        System.out.println(perGenderCount);
    }




    public static void main(String[] args) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.enterDetails();
        studentDetails.printAllDepartments();
        studentDetails.getStudentsEnrolledAfterYear(2018);
        studentDetails.getStudentForGivenGenderGivenDepartment("Male", "Computer Science");
        studentDetails.getNumberOfFemaleMale();
        studentDetails.getAverageAge();
        studentDetails.getStudentWithHighestPercentage();
        studentDetails.getStudentsPerEachDepartment();
        studentDetails.getAveragePerDepartment();
        studentDetails.getYoungestMaleInGivenDept("Electronic");
        studentDetails.getNumberOfFemaleMaleInGivenDept("Computer Science");
    }
}
