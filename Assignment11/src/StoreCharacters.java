import edu.duke.FileResource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class StoreCharacters {

    private HashMap<Character, Integer> counts;

    public StoreCharacters(){
        counts = new HashMap<Character, Integer>();
    }
    public void countCharacterOccurrencesInFile(String filename){
        FileResource fr = new FileResource(filename);
        System.out.println(fr.toString());
        char[] input = fr.asString().toCharArray();
        for(char ch: input){
            if(counts.containsKey(ch)){
                int count = counts.get(ch);
                counts.put(ch, count+1);
            }
            else{
                counts.put(ch, 1);
            }
        }
    }

    public void storeInFile() throws IOException {
        File f = new File("output.txt");
        FileWriter writer = new FileWriter(f);

        for(char ch: counts.keySet()){
            writer.append(ch + ": " + counts.get(ch) + "\n");
        }

        writer.flush();
        writer.close();

    }

}
