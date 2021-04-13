
/** Question
 *Create main class in package yourname.assignment.main,
 * create object of first class and call both the methods to print the values.
 * Create object of second class using static method and then call
 * the other method to print the String.

 One or more tasks mentioned above are not possible in JAVA,
 comment that part of the code with block comments and
 add the explanation for the same. */



package pooja.assignment.main;

import pooja.assignment.data.DefaultInitializationInData;
import pooja.assignment.singleton.DefaultInitializationInSingleton;

public class MainClass {

    public static void main(String[] args) {

        DefaultInitializationInData initialization = new DefaultInitializationInData();
        initialization.printMemberVariables();

        //Below function call throws an error
        //because local variables are used without initializing
        initialization.printLocalVariables();

        //Below lines throws an error
        //as we are trying to access non static variable from static
        // method in DefaultInitializationInSingleton class
        DefaultInitializationInSingleton initializationInSingleton =
                DefaultInitializationInSingleton.staticPrintNonStatic("Hello");
        initializationInSingleton.printWord();

    }
}
