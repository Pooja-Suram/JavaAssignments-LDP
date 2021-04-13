
/** Question:
 * Create a class in a package yourname.assignment.data containing an int
 * and a char member variables that are not initialized,
 * add a method to print these variables.
 * Add another method in the same class with two local variables
 * and print their values without initializing them.*/



package pooja.assignment.data;

public class DefaultInitializationInData {

    int number;
    char letter;

    public void printMemberVariables(){
        System.out.println("Number is: " + number);
        System.out.println("Letter is: "+ letter);
    }

    //this method given an error
    //because local variables in java should be initialized
    //before using in java
     public void printLocalVariables(){
        int localNum;
        char localChar;
        System.out.println("Local Number is: "+ localNum);
        System.out.println("Local Character is : " + localChar);
    }

}
