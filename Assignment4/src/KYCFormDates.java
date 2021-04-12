
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KYCFormDates {

    DateTimeFormatter format;

    public KYCFormDates(){
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    //Return range of dates to fill form
    public String computeDateInRange(LocalDate signUpDate, LocalDate currentDate){
        String lowerLimit = (signUpDate.plusDays(-30)).format(format);
        String upperLimit = (currentDate).format(format);
        return lowerLimit + " " + upperLimit;
    }

    //Return range of dates to fill form
    //where current date is out of range
    public String computeDateOutOfRange(LocalDate signUpdate){
        String lowerLimit = (signUpdate.plusDays(-30)).format(format);
        String upperLimit = (signUpdate.plusDays(30)).format(format);
        return lowerLimit + " " + upperLimit;
    }


    public String computeDateRange(String signUp, String current) throws ParseException {

        //converting given string into date format
        LocalDate signUpDate = LocalDate.parse(signUp, format);
        LocalDate currentDate = LocalDate.parse(current, format);

        //checking if signUp date is after currentDate
        if(signUpDate.compareTo(currentDate) > 0){
           return "NO RANGE";
        }

        //Calculating this year anniversary date to know the range
        String anniversaryDate = signUp.substring(0,6) + current.substring(6,10);
        signUpDate = LocalDate.parse(anniversaryDate, format);

        long diffInDays = ChronoUnit.DAYS.between(signUpDate, currentDate);

        //current date is within range of dates to fill form
        if(Math.abs(diffInDays) < 30){
            return computeDateInRange(signUpDate, currentDate);
        }

        //Current date is not in range of dates to fill form
        else{
            return computeDateOutOfRange(signUpDate);
        }
    }


    public static void main(String[] args) throws ParseException {

        KYCFormDates dates = new KYCFormDates();
        List<String> signUpDates = new ArrayList<String>();
        List<String> currentDates = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for(int i=0; i < testcases; i++) {
            String signUpDate = scanner.next();
            String currDate = scanner.next();
            signUpDates.add(signUpDate);
            currentDates.add(currDate);
        }

        System.out.println("\nRange of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy are: ");

        for(int i=0; i<testcases; i++){
            String ranges = dates.computeDateRange(signUpDates.get(i), currentDates.get(i));
            System.out.println(ranges);
        }

    }
}
