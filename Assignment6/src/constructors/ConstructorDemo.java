
/** Question:
 * Create a class with two (overloaded) constructors.
 * Using this, call the second constructor inside the first one. */

package constructors;

public class ConstructorDemo {

    private String message;

    public ConstructorDemo(){
        new ConstructorDemo("Hello");
    }

    public ConstructorDemo(String message){
        this.message = message;
    }

}
