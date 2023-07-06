package exercises.reflection;

public class Cat {
    @ImportantString
    private final String name;
    private int age;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("meow");
    }

    public void eat() {
        System.out.println("eat");
    }

    private void heyThisIsPrivate() {
        System.out.println("How did you call this??");
    }

    private static void thisIsAPrivateStaticMethod() {
        System.out.println("I am private and static");
    }
}
