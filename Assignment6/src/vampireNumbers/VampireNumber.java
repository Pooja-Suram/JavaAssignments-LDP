package vampireNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class VampireNumber {

    ArrayList<Integer> vampireNumbersList;

    public VampireNumber(){
        vampireNumbersList = new ArrayList<Integer>();
    }


    /** This method computes vampire numbers and prints them */
    public void printVampireNumbers(int count){

        String[] digitsInProduct, individualDigits;
        int product, vampireNumbersCount = 0;

        for(int varx = 10; varx < 1000; varx++) {
            for(int vary = 10; vary < 1000; vary++) {

                //Exit when required number of vampire numbers are obtained
                if(vampireNumbersCount >= count)
                    return;

                product = varx * vary;

                int numberLength = String.valueOf(product).length();
                int lengthOfVarX = String.valueOf(varx).length();
                int lengthOfVary = String.valueOf(vary).length();

                //Calculating whether number has even length
                if(numberLength % 2 != 0 && (lengthOfVarX != lengthOfVary)){
                    continue;
                }

                digitsInProduct = String.valueOf(product).split("");
                individualDigits = (String.valueOf(varx) + String.valueOf(vary)).split("");
                Arrays.sort(digitsInProduct);
                Arrays.sort(individualDigits);

                //check number is vampire or not by checking
                //whether product and two individual numbers has same digits
                if(Arrays.equals(digitsInProduct, individualDigits)) {
                    if(!vampireNumbersList.contains(product)) {
                        vampireNumbersList.add(product);
                        vampireNumbersCount++;
                        System.out.println(" "+ vampireNumbersCount + ". vampire number: " +product);
                    }
                }
            }
        }
    }
}

