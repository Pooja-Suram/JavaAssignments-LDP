
/** Question:
 * Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc.
 * In the base class, provide methods that are common to all Rodents,
 * and override these in the derived classes to perform different
 * behaviors depending on the specific type of Rodent.
 * Create an array of Rodent, fill it with different specific types of Rodents,
 * and call your base-class methods to see what happens.
 * Make the methods of Rodent abstract whenever possible and
 * all classes should have default constructors that print a message about that class. */

package rodents;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<Rodent> rodentList = new ArrayList<Rodent>();

        Rodent mouse = new Mouse();
        rodentList.add(mouse);
        mouse.describeRodent();

        Rodent gerbil = new Gerbil();
        rodentList.add(gerbil);
        gerbil.describeRodent();

    }
}
