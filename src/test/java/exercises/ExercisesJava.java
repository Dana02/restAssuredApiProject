package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
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

public class ExercisesJava {
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

        //Ex-4
        //getHowManyStepsTillZero(14);

        //Ex-5
//        int nums[] = {3, 2, 3, 2, 3};
//        System.out.println(element(nums));

        //Ex-6
//        int[] array = {1, 2, 3, -1, -2, 4};
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));

        //Ex-7 Write Java program that checks if two arrays contain the same elements.
//        Integer[] array = {1, 2, 3, -1, -2, 4};
//        Integer[] array2 = {1, 2, 3, -1, -2, 4};
//        System.out.println(sameElements(array, array2));

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


        //Ex-8
//        int[] array = {1, 2, 3, -1, -2, 4};
//        getSumOfIntegerArray(array); //попробувати самій написати

        //Ex-9
        //int[] array = {1, 7, 55, 4, -2, 33};
        // System.out.println(getSecondLargestNumber(array));

        //Ex-10
//        String name = "Welcome Java";
//        System.out.println(getReverseString(name));

        //Ex-11
        //swipeTwoNumbers(12, 33);

        //Ex-12
        //isNumberPrime(9);

        //Ex-13
        //findDuplicateCharacterInString("w3schools");

//        Object obj = new Object();
//        System.out.println(obj.hashCode());

        //Ex-14
        //reverseNumber(1234); ???

        //Ex-15
//        int[] array = {1, 7, 55, 4, 33};
//        int[] array2 = {1, 7, 55, 9, 33};
//        System.out.println(checkIfTwoArraysAreEqual(array, array2));

//        String[] s1 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};
//        String[] s2 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"};
//        Arrays.sort(s1);
//        Arrays.sort(s2);
//        System.out.println(Arrays.equals(s1, s2));

        //Ex-16
        //getSumOfAllNumber(432454); //щоб видалити останню цифру з числа треба поділити його на 10, а щоб взяти останню потрібно взяти number % 10

        //Ex-17
//        reverseEachWord("Java Concept Of The Day");
//
//        int a = 5;
//        //double a2 = a; //float also works
//        double a2 = (float) a; //also works
//        System.out.println(a2); //5.0
//
//        int a3 = 5;
//        float a4 = a3;

        //Ex-18
//        Integer [] myArray = {1,3,5,7,9};
//        System.out.println("Original Array:" + Arrays.asList(myArray));
//        reverseArray(myArray);

        //Ex-19
//        Integer[] myArray = {1, 3, 5, 7, 9, 2, 1, 3};
//        removeDuplicatesFromArray(myArray); //recreate

//        char c = 0x000A;
//        System.out.println(c); //print nothing

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

//        int[] myArray = {1, 3, 5, 2, 8, 9, 5, 0};
//        int x = myArray[0];
//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] < x) {
//                x = myArray[i];
//            }
//        }
//        System.out.println(x); //0

//        int num[] = new int[9];
//        for (int i = 0; i < num.length; i++) {
//            num[i] = i + 5;
//        }
//        System.out.println(num[7]); //12!!!!!

//        int[] arr = new int[9]; //arr [0,0,0,0,0,0,0,0,0]
//        System.out.println(arr[0]); //0

//        List<String> cоlleсtion = List.of("AA", "BB", "CC"); //immutable!!! java 9
//        for (String еlement : cоlleсtion) {
//            if (еlement.equals("AA")) {
//                cоlleсtion.remove(еlement); //ImmutableCollections exception
//            }
//        }

        //JAVA is always pass by value
        //!!!!!!!!!!!!!!
        int a = 5;
        System.out.println("a before " + a); //5
        change(a);
        System.out.println("a after " + a); //5

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        int[] myArray = {1, 2, 3, 4, 5};
        changeArr(myArray);
        System.out.println(Arrays.toString(myArray));// [99, 2, 3, 4, 5]


        int num = 10;
        //boxing
        Integer refInt = num;
        //unboxing
        int num2 = refInt;

        int b = 7;
        int c = 2;
        System.out.println(7/2); //b and c are int type. a/b will also be an int type. So the result 3.5 will become 3.
    }

    private static void change(int a) { //in primitive type we get value
        a++;
    }

    private static void changeArr(int[] oldArr) {//we get reference by value
//      int temp = arr[arr.length - 1];
//      oldArr[0] = temp;

        // oldArr[0] = 99; //will change oldArr[0]
        int[] newArr = oldArr; // we created new array and = it to OldArr
        newArr[0] = 99; //and this will change OldArr
    }

    public static void main(String args) {
        System.out.println("main2");
    }

    private static void removeDuplicatesFromArray(Object[] arrayWithDuplicates) {
        //1 example
//        Set<Object> newArray = new HashSet<>(Arrays.asList(myArray));
//        System.out.println(newArray);

        //Assuming all elements in input array are unique

        int numberOfUniqueElements = arrayWithDuplicates.length;

        for (int i = 0; i < numberOfUniqueElements; i++) {
            for (int j = i + 1; j < numberOfUniqueElements; j++) {
                //If any two elements are found equal
                if (arrayWithDuplicates[i] == arrayWithDuplicates[j]) {
                    //Replace duplicate element with last unique element
                    arrayWithDuplicates[j] = arrayWithDuplicates[numberOfUniqueElements - 1];
                    //Decrementing numberOfUniqueElements
                    numberOfUniqueElements--;
                    //Decrementing j
                    j--;
                }
            }
        }

        //Copying only unique elements of arrayWithDuplicates into arrayWithoutDuplicates
        Object[] arrayWithoutDuplicates = Arrays.copyOf(arrayWithDuplicates, numberOfUniqueElements);

        for (int i = 0; i < arrayWithoutDuplicates.length; i++) {
            System.out.print(arrayWithoutDuplicates[i] + "\t");
        }
    }

    private static void reverseArray(Integer[] array) {
        //1 example
//        for (int i = array.length - 1; i >= 0; i--) {
//            System.out.print(array[i]);
//        }

        //2 example
        Collections.reverse(Arrays.asList(array));
        System.out.println("Reversed Array:" + Arrays.asList(array));
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

    private static void getSumOfAllNumber(int number) {
        int sum = 0;

        while (number != 0) {
            //get last digit of number
            int lastDigit = number % 10;
            //add last digit to sum
            sum = sum + lastDigit;
            //remove last digit from input number
            number = number / 10;
        }
        System.out.println("Sum Of All Digits In " + number + " = " + sum);
    }


    private static boolean checkIfTwoArraysAreEqual(int[] array, int[] array2) {
        boolean isEqual = true;
        if (array.length == array2.length) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != array2[i]) {
                    isEqual = false;
                }
            }
        }
        return isEqual;
    }

    private static void reverseNumber(int number) {
        int reverse = 0;
        int remainder = 0;
        do {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;

        } while (number > 0);

        System.out.println(number);
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

    private static void isNumberPrime(int number) {
        if (number % 2 == 0) {
            System.out.println("false");
        } else if (number <= 1) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    private static void swipeTwoNumbers(int firstNumber, int secondNumber) {
        int thirdNumber = firstNumber; //12
        firstNumber = secondNumber; //33
        secondNumber = thirdNumber;//12
        System.out.println(firstNumber + " " + secondNumber);
    }

    private static String getReverseString(String name) {
        String reverseString = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverseString = reverseString + name.charAt(i);
        }
        return reverseString;
    }

    private static int getSecondLargestNumber(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }

    private static void getSumOfIntegerArray(int[] array) {
        int sum = 0;
        for (Integer arr : array) {
            sum += arr;
        }
        System.out.println(sum);
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

    private static void getHowManyStepsTillZero(int number) {
        int step = 0;
        while (number != 0) {
            if (number % 2 == 0) {
                number = number / 2;
                step = step + 1;
            } else {
                number = number - 1;
                step = step + 1;
            }
        }
        System.out.println(step);
    }

    private static int element(int nums[]) {
        int countOfElements = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > countOfElements) {
                return num;
            }
        }
        return -1;
    }

    private static boolean sameElements(Object[] array1, Object[] array2) {
        Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
        Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));

        if (uniqueElements1.size() != uniqueElements2.size()) {
            return false;
        }
        for (Object obj : uniqueElements1) {
            if (!uniqueElements2.contains(obj)) {
                return false;
            }
        }
        return true;
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

