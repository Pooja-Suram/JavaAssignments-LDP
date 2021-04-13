
/* This class inherits Rodent class */


package rodents;

public class Gerbil extends Rodent{

    public Gerbil(){
        System.out.println("\nIam Gerbil. I inherit from Rodent");
    }

    @Override
    public void describeRodent() {
        System.out.println("Iam a type of Rodent: Gerbil. My tail is fatter and furrier than Mouse's");
    }
}
