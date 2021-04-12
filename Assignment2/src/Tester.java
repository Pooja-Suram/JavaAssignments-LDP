public class Tester {
    public static void main(String[] args) {
        StringWithAllLetters stringLetters = new StringWithAllLetters();
        String inputString = "ABCDEFGHIJKLMnopqrstuvwxyz";
        boolean result = stringLetters.checkAllLetters(inputString);
        if(result){
            System.out.println("Given string has all letters from a-z(case insensitive)");
        }
        else{
            System.out.println("Given string doesn't has all letters a-z");
        }
    }
}
