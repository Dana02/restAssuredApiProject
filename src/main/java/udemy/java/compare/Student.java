package com.udemy.java.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Student {

    private String name;
    private int score;
    private int height;

    public Student(String name, int score, int height) {
        this.name = name;
        this.score = score;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", height=" + height +
                '}';
    }


    public static void main(String[] args) {
        Student a = new Student("Adam", 80, 150);
        Student b = new Student("Bob", 90, 123);
        Student c = new Student("Carl", 75, 135);

        Optional<Student> op = Stream.of(a, b, c)
                .min(Comparator.comparing(student -> student.getScore())); //Student{name='Carl', score=75, height=135}

        System.out.println(op.get());

        //find sum with stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = list.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);

        //instead traditional for loop
        IntStream.range(1,10)
                .forEach(i-> System.out.println("hello world :: " + i));
    }
}
