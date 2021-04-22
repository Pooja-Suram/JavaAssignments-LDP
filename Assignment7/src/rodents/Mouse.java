/* This class inherits Rodent class */

package rodents;

public class Mouse extends Rodent{

    public Mouse(){
        System.out.println("\nIam a Mouse. I inherit from Rodent");
    }

    public void describeRodent(){
        System.out.println("I am type of Rodent:  Mouse. My ears are much bigger than Gerbil's");
    }
}
