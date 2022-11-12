package com.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Intro {
    public static void main(String[] args) {
        Stream<Integer> checkStream = Stream.of(2,34,232,1,5,23,4);
//        checkStream.forEach(System.out::println);
        checkStream.forEach(s-> System.out.println(s));



        List<String>list=new ArrayList<>();
        list.add("H");
        list.add("E");
        list.add("L");
        list.add("L");
        list.add("o");

        Stream<String> checkStreamList=list.stream();
        checkStreamList.forEach(s-> System.out.println(s));;
    }
}
