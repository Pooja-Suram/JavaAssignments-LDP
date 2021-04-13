
/** Question:
 * Create a class with a constructor that takes a String argument.
 * During construction, print the argument.
 * Create an array of object references to this class,
 * but don’t actually create objects to assign into the array.
 * When you run the program, notice whether the initialization messages
 * from the constructor calls are printed. */

package constructors;

import java.util.ArrayList;
import java.util.List;

public class InitializationDemo1 {

    public InitializationDemo1(String input){
        System.out.println("Initialized. Given argument is: " + input);
    }

    public static void main(String[] args) {

        //When we are creating list of InitializationDemo1 objects
        // Initialization messages are not printed
        // because we are not initializing InitializationDemo1 class

        List<InitializationDemo1> listOfObjects = new ArrayList<InitializationDemo1>();
    }
}
