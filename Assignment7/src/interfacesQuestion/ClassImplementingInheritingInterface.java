
/** Question:
 * Create three interfaces, each with two methods.
 * Inherit a new interface that combines the three, adding a new method.
 * Create a class by implementing the new interface and also inheriting
 * from a concrete class. Now write four methods,
 * each of which takes one of the four interfaces as an argument.
 * In main( ), create an object of your class and pass it to each of the methods.*/




package interfacesQuestion;

public class ClassImplementingInheritingInterface implements InheritingInterface{
    @Override
    public void extraMethodOfInheritingInterface() {
    }

    @Override
    public void printMethodInterface1() {
    }

    @Override
    public void updateMethodInterface1() {

    }

    @Override
    public void printMethodInterface2() {

    }

    @Override
    public void updateMethodInterface2() {

    }

    @Override
    public void printMethodInterface3() {

    }

    @Override
    public void updateMethodInterface3() {

    }

    public void methodForInterface1(Interface_1 interface1){
        System.out.println("Method taking Interface1 as argument");
    }

    public void methodForInterface2(Interface_2 interface1){
        System.out.println("Method taking Interface2 as argument");
    }

    public void methodForInterface3(Interface_3 interface1){
        System.out.println("Method taking Interface3 as argument");
    }

    public void methodForInheritingInterface(InheritingInterface interface1){
        System.out.println("Method taking InheritingInterface as argument");
    }

    public static void main(String[] args) {
        ClassImplementingInheritingInterface demoObject = new ClassImplementingInheritingInterface();
        demoObject.methodForInterface1(demoObject);
        demoObject.methodForInterface2(demoObject);
        demoObject.methodForInterface3(demoObject);
        demoObject.methodForInheritingInterface(demoObject);
    }
}
