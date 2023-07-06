package exercises;

import java.util.*;
import java.util.stream.Collectors;

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

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

//    public Product(byte var){
//        this(4); //compilation error;
//    }
}

class Test1 {
    static {
        System.out.println("static");
    }

    {
        System.out.println("instance");
    }

    public Test1() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1(); //static instance Constructor
    }
}

class a {

    public int method2() {
        return 10;
    }
}

class b extends a {

    public int method1() {
        return super.method2(); //МИ МОЖЕМО ВЕРТАТИ SUPER i THIS
    }
}

public class StringExercises {
    public static void main(String[] args) {
        //Ex-1
        //getCountOfEachCharacter("Welcome Java");
        //getCountOfEachCharacterUsingHashMap("Welcome Java");
        //getCountOfEachCharacterUsingJava8("Welcome Java");

        //Ex-2 - Remove spaces from a string without using replace()
//        String test = "I like it move    it move, it   .";
//        char[] testChatArray = test.toCharArray();
//        for (Character c : testChatArray) {
//            if (c != ' ') {
//                System.out.print(c);
//            }
//        }

        //Ex-3 - Remove the first letter from words, but only those which consist of more than 1 letter
//        String test = "I like to move it move, it.";
//        String arr[] = test.split(" "); // [I, like, to, move, it, move,, it.]
        // System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i].length() > 1) {
//                System.out.print(arr[i].substring(1) + " ");
//            } else {
//                System.out.print(arr[i].substring(0) + " ");
//            }
//        }

        //Streams
//        List<Product> productsList = new ArrayList<Product>();
//        productsList.add(new Product(1, "HP Laptop", 25000f));
//        productsList.add(new Product(2, "Dell Laptop", 30000f));
//        productsList.add(new Product(3, "Apple Laptop", 90000f));

//        List<Float> priceList = productsList.stream()
//                .filter(p -> p.price <30000) //filtering data
//                .map(p -> p.price) //fetching price
//                .collect(Collectors.toList());
//        System.out.println(priceList);

//        productsList.stream()
//                .filter(product -> product.price == 30000)
//                .forEach(product -> System.out.println(product.name));

//        double sum = productsList.stream()
//                .collect(Collectors.summingDouble(product -> product.price));
//        System.out.println(sum);

//        Product product = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1).get();
//        System.out.println(product.price);
//
//        Product productB = productsList.stream().min((product1, product2) -> product1.price > product2.price ? 1 : -1).get();
//        System.out.println(product.price);

//        long count = productsList.stream()
//                .filter(product->product.price<30000)
//                .count();
//        System.out.println(count);

        // Converting product List into Set
//        Set<Float> productPriceList =
//                productsList.stream()
//                        .filter(product -> product.price < 30000)   // filter product on the base of price
//                        .map(product -> product.price)
//                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
//        System.out.println(productPriceList);

        // Converting Product List into a Map
//        Map<Integer,String> productPriceMap =
//                productsList.stream()
//                        .collect(Collectors.toMap(p->p.id, p->p.name));
//     System.out.println(productPriceMap);

        //Ex-10
//        String name = "Welcome Java";
//        System.out.println(getReverseString(name));

        //Ex-13
        //findDuplicateCharacterInString("w3schools");

//        Object obj = new Object();
//        System.out.println(obj.hashCode());

        //Ex-17
//        reverseEachWord("Java Concept Of The Day");

        //main("think"); //print main2

        //Ex-20
//        Map m = new HashMap();
//        m.put(null, "Test");
//        m.put(null, "Fest");
//        System.out.println(m); //{null=Fest}

        //Ex-21
//        String a = "abc";
//        String b = "abc"; //економія пам'яті - засовує в одну силку атвоматично
//        System.out.println(a.equals(b)); //true
//        System.out.println(a == b); //true
//
//        String a1 = "abc";
//        String b1 = new String("abc");
//        System.out.println(a1.equals(b1)); //true
//        System.out.println(a1 == b1); //false
//
//        String a2 = new String("abc");
//        String b2 = new String("abc");
//        System.out.println(a2.equals(b2)); //true
//        System.out.println(a2 == b2); //false

//        List<String> cоlleсtion = List.of("AA", "BB", "CC"); //immutable!!! java 9
//        for (String еlement : cоlleсtion) {
//            if (еlement.equals("AA")) {
//                cоlleсtion.remove(еlement); //ImmutableCollections exception
//            }
//        }
    }


    public static void main(String args) {
        System.out.println("main2");
    }

    private static void reverseEachWord(String string) {
        String[] words = string.split(" ");//["Java", "Concept", "Of", "The", "Day"]
        String reverseString = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reverseString = reverseString + reverseWord + " ";
        }
        System.out.println(reverseString);
    }

    private static void findDuplicateCharacterInString(String string) {
        char[] charArray = string.toCharArray();
        System.out.println("The String is " + string);
        System.out.println("Duplicate character are: ");

        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); i++) {
                if (charArray[i] == charArray[j]) {
                    System.out.print(charArray[j] + " ");
                    break;
                }
            }
        }
    }

    private static String getReverseString(String name) {
        String reverseString = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverseString = reverseString + name.charAt(i);
        }
        return reverseString;
    }

    public static void getCountOfEachCharacter(String givenString) {
        int[] count = new int[256];

        //кількість символів
        for (int i = 0; i < givenString.length(); i++) {
            count[givenString.charAt(i)]++;
        }

        //ініціалізація нового араю з символами з строки
        char[] charArray = givenString.toCharArray();

        //перебирання по новому араї символів
        for (int i = 0; i < charArray.length; i++) {
            int found = 0;
            for (int j = 0; j <= i; j++) {
                if (givenString.charAt(i) == charArray[j]) {
                    found++;
                }
            }
            if (found == 1) {
                System.out.println("Character " + givenString.charAt(i) + " count " + count[givenString.charAt(i)]);
            }
        }
    }

    /* In the following Java program, we have used Java HashMap to count the occurrence of each character in the given string. We know that
    the HashMap stores key and value pairs and does not hold the duplicate key. The program stores character as a key and the occurrence of character as a value.
    First, we have converted the given string into the character array and iterate over the character array one by one.
    Update the count value in the HashMap.
    After that, for each character, we need to verify if the key already exists in the HashMap or not.
    If exists, increase the count variable, else add it to the map as a new key and provide the initial value with count 1.*/
    public static void getCountOfEachCharacterUsingHashMap(String givenString) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = givenString.length() - 1; i >= 0; i--) {
            if (charCountMap.containsKey(givenString.charAt(i))) {
                int count = charCountMap.get(givenString.charAt(i));
                charCountMap.put(givenString.charAt(i), ++count);
            } else {
                charCountMap.put(givenString.charAt(i), 1);
            }
        }
        System.out.println(charCountMap);
    }


    /* In the following Java program, we have used the Java 8 features. First, we have initialized a string of which occurrence of the character is to be counted.
     After that, we have created an instance of the Java Map<>. We have performed various intermediate operations to get the occurrence of the character.
    First, the given string is split into the array by using the String.split() method. After that, the Arrays.stream() method returns a stream of the passed array.

    The second intermediate operation is to convert the string into lowercase letters. For the same, we have used the Stream.map() method that returns a stream
    consisting of the results of applying the given function to the elements of this stream.
    The collect() function is used to perform a mutable reduction operation and concatenate the list elements. The Collectors.groupingBy() method returns a
    Collector implementing a cascaded "group by" operation on input elements of type T.
    In order to count the elements, we have used the counting() method of the Collectors class. The method returns a Collector accepting elements of type T.
    It counts the number of input elements, if no elements are present, the result is 0.*/
    public static void getCountOfEachCharacterUsingJava8(String givenString) {
        Map<String, Long> resultMap = Arrays.stream(givenString.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        System.out.println(resultMap);
    }

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

