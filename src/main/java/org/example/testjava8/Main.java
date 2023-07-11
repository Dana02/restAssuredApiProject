package org.example.testjava8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ball");
        list.add("ball");
        list.add("cat");

//        System.out.println(list
//                .stream()
//                .filter(s -> s.length() >= 3)
//                .findFirst()); //Optional
//
//        System.out.println(list
//                .stream()
//                .min(Comparator.naturalOrder())
//                .get());
//
//        System.out.println(list
//                .stream()
//                .min(Comparator.reverseOrder())
//                .get());

//        List<String> list2 = list.stream()
//                .filter(s -> s.length() > 3)
//                .collect(Collectors.toList()); //we don't touch original list
//
//        System.out.println("Original :: " + list);
//        System.out.println("Original toList():: " + list2);

//        Set<String> set = list.stream() //original
//                .filter(s -> s.length() > 3)
//                .collect(Collectors.toSet()); //we don't touch original list
//
//        System.out.println("Original :: " + list);
//        System.out.println("Original toList():: " + set);

//        String joinedString = list.stream()
//                .filter(s -> s.length() > 3)
////                .collect(Collectors.joining()); //appleballball
//                .collect(Collectors.joining(";")); //apple;ball;ball
//
//        System.out.println(joinedString);

//        Map<Integer, List<String>> collect = list.stream()
//                .collect(Collectors.groupingBy(String::length)); //{3=[cat], 4=[ball, ball], 5=[apple]}
//        System.out.println(collect);
//
//        Map<Character, List<String>> collect2 = list.stream()
//                .collect(Collectors.groupingBy(s -> s.charAt(0))); //{a=[apple], b=[ball, ball], c=[cat]}
//        System.out.println(collect2);

        //JAVA 9
        Stream<Integer> intList = Stream.of(1, 2, 5, 7, 8, 9, 4);
        System.out.println(intList
                .takeWhile(i -> i < 5)
                .collect(Collectors.toList()));

        Stream<Integer> intList2 = Stream.of(6, 1, 2, 5, 7, 8, 9, 4); //виведе всі якщо перший ел не тру
        System.out.println(intList2
                .dropWhile(i -> i < 5)
                .collect(Collectors.toList()));

        //immutable
        List<Integer> list1 = List.of(1, 2, 3, 5); //its immutable list
        Set<String> set = Set.of("ab", "bc"); //immutable set without order
        Map<Integer, String> map = Map.of(1, "2", 2, "4"); //immutable map

        //JAVA 10
        //var for more readable code - only in method, cannot be used in lambda
        var num = 10;
        var list2 = List.of(1, 2, 3);
        var map2 = Map.of("name", 12, "name2", 13);
        var var = 5; //NOT KEYWORD


        //JAVA 11
        // String s = "  "; //""-> empty
        //System.out.println(s.isEmpty()); //false
        //spaces is empty
        //System.out.println(s.isBlank()); //true - java 11

        // String str = "hi\nhello\nhow";
        // System.out.println(str);
        // System.out.println(str.lines());//stream

//        String str2 = "hi";
//        System.out.println(str2.repeat(2)); //hihi

        String str3 = "  hi  ";
        System.out.println(str3.strip());//like trim but also remove unicode characters //hi

        //read and write to file
        Path path = Paths.get("path");
        Files.writeString(path, "what to write in file");
        Files.readString(path); //get what is in file

    }

    private static void test1(int a) {
        Consumer<Integer> test = (i -> {
            var num = 10; //we can use inside lambda because it's a method
            System.out.println(i);
        });

        //cannot use here
        //var test2 = (i -> System.out.println(i));
    }

}
