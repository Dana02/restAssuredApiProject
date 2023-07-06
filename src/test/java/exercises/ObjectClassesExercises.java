package exercises;

class Parent {
}

class Child extends Parent {
    public static void main(String[] args) {
        //UPCASTING/DOWNCASTING
        // Child child = new Parent(); //we cannot do it
        Parent parent = new Child();
    }
}

class PrivateConstructor {

    private PrivateConstructor() {
    }

    public static void main(String[] args) {
        PrivateConstructor privateConstructor = new PrivateConstructor();
    }
}

//Compilation error - There is no default constructor available in 'exercises.PrivateConstructor'
//class PublicConstructor extends PrivateConstructor {
//    public static void main(String[] args) {
//        PrivateConstructor privateConstructor = new PrivateConstructor();//PrivateConstructor()' has private access
//    }
//}

public class ObjectClassesExercises {
    interface A1 {
        String s = "hi";

        void method1();
    }

    interface B {
    }

    interface C extends A1, B {
        void method1();

        void method1(int i);
    }
}

class OrderOfRunning {
    static {
        System.out.println("static");
    }

    {
        System.out.println("instance");
    }

    public OrderOfRunning() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        //1static, 2instance, 3Constructor
        OrderOfRunning test = new OrderOfRunning();
    }
}

//МИ МОЖЕМО ВЕРТАТИ SUPER i THIS
class a {
    public int method2() {
        return 10;
    }
}

class b extends a {

    public int method1() {
        return super.method2();
    }
}

class Overload {
    //OVERLOADING
    public Integer getVal(int i) {
        return i;
    }

    public String getVal(int i, int q) {
        return "";
    }

    public Long getVal(String i) {
        return null;
    }

    private int getArea(int a) {
        return a * a;
    }

    private double getArea(double a) {
        return a * a;
    }

    private double getArea(double a, int a2) {
        return a * a2;
    }

    private double getArea(int a, double a2) {
        return a * a2;
    }
}