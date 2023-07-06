package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringExercises {

    public static void main(String args) {
        System.out.println("main2");
    }

    public static void main(String[] args) {
        System.out.println(getCountOfSpecificCharacter("danahaha", 'a'));

        main("think"); //print main2

        //Ex-1
        getCountOfEachCharacter("Welcome Java");
        getCountOfEachCharacterUsingHashMap("Welcome Java");
        getCountOfEachCharacterUsingJava8("Welcome Java");

        //Ex-2 - Remove spaces from a string without using replace()
        String test = "I like it move    it move, it   .";
        char[] testChatArray = test.toCharArray();
        for (Character c : testChatArray) {
            if (c != ' ') {
                System.out.print(c);
            }
        }

        //Ex-3 - Remove the first letter from words, but only those which consist of more than 1 letter
        String test2 = "I like to move it move, it.";
        String arr[] = test2.split(" "); // [I, like, to, move, it, move,, it.]
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 1) {
                System.out.print(arr[i].substring(1) + " ");
            } else {
                System.out.print(arr[i].substring(0) + " ");
            }
        }

        //_______________________________________
        String name = "Welcome Java";
        System.out.println(getReverseString(name));

        //_______________________________________
        findDuplicateCharacterInString("w3schools");

        Object obj = new Object();
        System.out.println(obj.hashCode());

        //_______________________________________
        reverseEachWord("Java Concept Of The Day");

        //_______________________________________
        String a = "abc";
        String b = "abc"; //економія пам'яті - засовує в одну силку атвоматично
        System.out.println(a.equals(b)); //true
        System.out.println(a == b); //true

        String a1 = "abc";
        String b1 = new String("abc");
        System.out.println(a1.equals(b1)); //true
        System.out.println(a1 == b1); //false

        String a2 = new String("abc");
        String b2 = new String("abc");
        System.out.println(a2.equals(b2)); //true
        System.out.println(a2 == b2); //false


        reverseStringNotNumbers("java679python899");

    }

    private static void reverseStringNotNumbers(String string) {

    }

    private static int getCountOfSpecificCharacter(String string, char character) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }

        return count;
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
}

