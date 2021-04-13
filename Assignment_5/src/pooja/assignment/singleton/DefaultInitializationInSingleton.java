
/** Question:
 * Create another class in package yourname.assignment.singleton
 * containing a non static String member variable. Add a static method that
 * takes String as parameter and initialize the member variable
 * and then return object of that class. Add a non static method to print the String. */



package pooja.assignment.singleton;

public class DefaultInitializationInSingleton {

    String word;

    public static DefaultInitializationInSingleton staticPrintNonStatic(String input){

        //this line throws error
        //because we are trying to access non static variable from static method
        DefaultInitializationInSingleton.word = input;
        return new DefaultInitializationInSingleton();
    }

    public void printWord(){
        System.out.println("Word is: " + word);
    }

}
