
/**Question:
 * Write a java function that will ping any host
 * ( given as input ) and computes the median of the time taken to ping. */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.DoubleUnaryOperator;

public class PingHost {

    List<String> commandList;
    List<Double> responseTimes;

    public  PingHost(){
        commandList = new ArrayList<String>();
        responseTimes = new ArrayList<Double>();
    }

    public double calculateMedianOfTime(){

        //sort the list to calculate median
        Collections.sort(responseTimes);
        responseTimes.remove(responseTimes.size()-1);

        int length = responseTimes.size();
        int midIndex = length/2;

        //If there are even number of elements in list,
        //middle element is median
        if(length%2==1){
            return (responseTimes.get(length/2));
        }

        //If there are odd number of elements
        //average of middle 2 elements is median
        return (responseTimes.get(length/2) + responseTimes.get((length-1)/2) )/2;
    }



    //This method pings the given host by sending count number of ping requests
    public void pingGivenHost(String ping, String host, String count) throws IOException {
        commandList.add(ping);
        commandList.add(host);
        commandList.add(count);

        //create a process builder with command list that is to be executed
        ProcessBuilder build = new ProcessBuilder(commandList);

        //start the process
        Process process = build.start();

        //read the output that is being given
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String data = null;
        while((data = input.readLine()) != null){

            //store ping times taken in response time list
            if(data.contains("time")) {
                int index = (data.indexOf("time"));
                double time = Double.parseDouble(data.substring(index+5, index+5+4));
                responseTimes.add(time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String ping = "ping";

        System.out.println("Enter the host you want to ping");
        Scanner sc = new Scanner(System.in);
        String host = sc.next();

        String count = "-c3";

        PingHost pingHost = new PingHost();
        pingHost.pingGivenHost(ping, host, count);
        double median = pingHost.calculateMedianOfTime();
        System.out.println("Median of time taken to ping is: " + median + " ms");
    }

}
