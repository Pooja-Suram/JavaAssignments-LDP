
/** Question:
 * Complete the InitializationDemo1 class by creating objects
 * to attach to the array of references. */

package constructors;

import java.util.ArrayList;
import java.util.List;

public class InitializationDemo2 {

    public InitializationDemo2(String input){
        System.out.println("Initializing. Given argument is: " + input);
    }

    public static void main(String[] args) {
        List<InitializationDemo2> listOfObjects = new ArrayList<InitializationDemo2>();

        //Here Initialization messages will be printed
        // as we are instantiating InitializationDemo2 class
        for(int i=0; i<5; i++){
            listOfObjects.add(new InitializationDemo2("hello" + i));
        }
    }

}
