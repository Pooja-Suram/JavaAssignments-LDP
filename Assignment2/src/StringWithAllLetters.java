

/** Question: Write a java program to check whether given string
 * has all the letters a-z(case insensitive)
 * Write time and space complexity of your solution as comments in the source file.*/

/** Time complexity : O(n) where n is length of the given string
 * Space complexity : O(n) where n is length of given string */

import java.util.HashMap;

public class StringWithAllLetters {

    private HashMap<Character, Integer> counts;

    public StringWithAllLetters(){
        counts = new HashMap<Character, Integer>();
    }

    private void initializeCounts(){
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<alphabets.length(); i++){
            counts.put(alphabets.charAt(i), 0);
        }
    }

    public boolean checkAllLetters(String input){
        initializeCounts();
        for(int i=0; i<input.length(); i++){
            char currentChar = Character.toLowerCase(input.charAt(i));
            if(Character.isAlphabetic(currentChar)){
                int value =  counts.get(currentChar);
                counts.put(currentChar, value+1);
            }
        }

        for(Character character: counts.keySet()){
            if(counts.get(character) == 0){
                return false;
            }
        }
        return true;
    }
}
