
/** Question:
 * Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
 * Add a balance( ) method to Unicycle and Bicycle,
 * but not to Tricycle.Create instances of all three types
 * and upcast them to an array of Cycle. Try to call balance( ) on each
 * element of the array and observe the results. Downcast and call balance( )
 * and observe what happens. */



package cycles;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Cycle> cycles = new ArrayList<Cycle>();

        //Upcasting
        cycles.add(new Unicycle());
        cycles.add(new Bicycle());
        cycles.add((new Tricycle()));

        //following code throws an error
        //because objects created are Cycle type
        //and Cycle class doesn't has balance() method
        for(Cycle cycle: cycles){
            cycle.balance();
        }

        //Downcasting
        //Following code works fine,
        //Because, we are creating an object of Unicycle type,
        //and Unicycle class has balance() method
        Unicycle unicycle = (Unicycle)cycles.get(0);
        unicycle.balance();

        //Downcasting
        Bicycle bicycle = (Bicycle)cycles.get(1);
        bicycle.balance();


    }

}
