
/** Question:
 * Using TextFile and a Map<Character,Integer>,
 * create a program that takes the file name as a command line argument and
 * counts the occurrence of all the different characters.
 * Save the results in a text file. */

//outputs are save in output.txt
// input_file.txt is taken as input file

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {

        StoreCharacters characters = new StoreCharacters();
        characters.countCharacterOccurrencesInFile("input_file.txt");
        characters.storeInFile();

    }
}
