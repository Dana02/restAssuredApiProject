package com.udemy.java;


import com.udemy.java.lambda.GreetingService;
import com.udemy.java.lambda.StringOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestMain {

    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        //Higher order function
//        GreetingService g1 = (firstName -> firstName.toUpperCase()); //ми асайнимо функцію змінній
//        test(g1); //DANA
//
//        test((n) -> n.toLowerCase() + n.toUpperCase());//danaDANA

//        String str = getLambda().greet("data");
//        System.out.println(str);

        //without any params
//        StringOperations stringOperations = System.out::println; //implementation of method accept
//        stringOperations.accept("test");

//        StringOperations stringOperations2 = Objects::isNull; //implementation of method accept
//        System.out.println(stringOperations2.accept("test"));

        //(s) -> s.toUpperCase()
        // StringOperations stringOperations3 = String::toUpperCase;

        //(s1,s2) -> s1.concat(s2) - якщо 2 параметри в методі інтерфейсу
        //String op1 = String::concat;


//        StringOperations op2 = s -> list.add(s);
//        op2.accept("addedToList");
//        System.out.println(list);
        StringOperations op2 = list::add;
        op2.accept("addedToList");
        System.out.println(list);

    }

    private static GreetingService getLambda() {
        GreetingService g = s -> s.toUpperCase();
        return g;
    }

    private static void test(GreetingService g) { //receive another function as parameter
        String returnedString = g.greet("dana");
        System.out.println(returnedString);
    }
}
