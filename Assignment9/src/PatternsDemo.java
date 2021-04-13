
/** Question:
 * Using the documentation for java.util.regex.Pattern as a resource,
 * write and test a regular expression that checks a sentence to
 * see that it begins with a capital letter and ends with a period. */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternsDemo {

    public static void main(String[] args) {

        String message = "Hello i am pooja.";

        Pattern pattern = Pattern.compile("^[A-Z][A-Za-z ]*[.]$");
        Matcher match = pattern.matcher(message);
        if(match.matches()){
            System.out.println("Given string starts with capital letter and ends with '.'");
        }
        else{
            System.out.println("Given string doesn't start with capital letter or end with '.'");
        }


    }
}
