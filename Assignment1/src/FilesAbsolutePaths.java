import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FilesAbsolutePaths {

    Stack<File> directoriesStack;
    ArrayList<String> matchedFiles;

    /**This method scans through home directory
     * and subdirectories and prints absolute paths */
    private void searchFilesMatchingGivenPattern(String pattern){
        directoriesStack = new Stack<File>();
        matchedFiles = new ArrayList<>();
        searchHomeDirectory(pattern);
        searchSubDirectories(pattern);
        printAbsolutePathsOfMatchingFiles();
    }


    /**This method searches through home directory
     for files matching given pattern*/
    private void searchHomeDirectory(String pattern){
        File homeDirectory = new File("/home/poojs");
        for (File file : Objects.requireNonNull(homeDirectory.listFiles()))
        {
            if (file.isDirectory()) {
                //If directory then pushed to the stack
                directoriesStack.push(file);
            }
            else {
                if (file.isFile() && Pattern.matches(pattern, file.getName())) {
                    //If a file and matches with REGEX add its absolute path
                    matchedFiles.add(file.getAbsolutePath());
                }
            }
        }
    }

    /**This method searches through sub directories */
    private void searchSubDirectories(String pattern){
        while (!directoriesStack.empty()) {
            File currentDirectory = directoriesStack.pop();
            for (File file : Objects.requireNonNull(currentDirectory.listFiles())
            ) {
                if (file.isDirectory()) {
                    //If directory then pushed to the stack
                    directoriesStack.push(file);
                } else {
                    if (file.isFile() && Pattern.matches(pattern, file.getName())) {
                        //If a file and matches with REGEX add its absolute path
                        matchedFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private void printAbsolutePathsOfMatchingFiles(){
        for (String matched : matchedFiles
        ) {
            System.out.println(matched);
        }
    }

    /** This method takes input pattern from user
     * and sends that input to another method to search for files
     * which matches that pattern*/
    public void takePatternInputsAndSearchFiles(){
        while(true){
            try {
                System.out.println("Enter Regular Expression matching to file:");
                Scanner scanner = new Scanner(System.in);
                String pattern = scanner.nextLine();

                //Stop taking inputs
                if (pattern.equalsIgnoreCase("Exit"))
                    break;
                searchFilesMatchingGivenPattern(pattern);
                System.out.println("Type (EXIT) to quit");
            }
            catch (PatternSyntaxException patternSyntaxException) {
                System.out.println("Please give correct syntax for Regular Expression Pattern");
                System.out.println(patternSyntaxException);
            }
        }
    }


    public static void main(String[] args) {
        FilesAbsolutePaths filePaths = new FilesAbsolutePaths();
        filePaths.takePatternInputsAndSearchFiles();
    }
}
