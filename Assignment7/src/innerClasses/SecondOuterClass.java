package innerClasses;

public class SecondOuterClass {

    //Below code throws an error
    //Because FirstInnerClass doesn't has default constructor
    class SecondInnerClass extends FirstOuterClass.FirstInnerClass{

    }
}
