
/** Question:
 * Create a Cycle interface, with implementations Unicycle,
 * Bicycle and Tricycle. Create factories for each type of Cycle,
 * and code that uses these factories. */

package cyclesInterface;

public class MainClass {

    public static void main(String[] args) {

        BicycleFactory bicycleFactory = new BicycleFactory();
        bicycleFactory.describeFactory(new Bicycle());

        UnicycleFactory unicycleFactory = new UnicycleFactory();
        unicycleFactory.describeFactory(new Unicycle());

        TricycleFactory tricycleFactory = new TricycleFactory();
        tricycleFactory.describeFactory(new Tricycle());
    }

}
