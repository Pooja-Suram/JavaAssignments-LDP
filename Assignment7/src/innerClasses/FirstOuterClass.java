
/** Question:
 * Create a class with an inner class that has a non-default
 * constructor (one that takes arguments).
 * Create a second class with an inner class that inherits
 * from the first inner class. */

package innerClasses;

public class FirstOuterClass {

    public  class FirstInnerClass{

        public FirstInnerClass(String message){
            System.out.println(message);
        }
    }
}
