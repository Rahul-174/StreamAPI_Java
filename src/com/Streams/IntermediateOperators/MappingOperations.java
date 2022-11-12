package com.Streams.IntermediateOperators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


//Filter doesn't work on 2D. so, we need to flatten that first and then apply filter
//

public class MappingOperations {
    public static void main(String[] args) {
        List<Integer>intList =new ArrayList<>();
        intList.add(12);
        intList.add(23);
        intList.add(1);
        intList.add(2);
        intList.add(10);
        intList.add(11);

        intList.stream().map(s->s*2).forEach(System.out::println);
        System.out.println(intList+"\n\n"); //not affecting the original


 /*
    PROBLEM STATEMENT :  Array of string, return a new array of string that includes those characters<5(length<5)
                         and change all the new array into UpperCase
 */
        List<String>strList=new ArrayList<>();
        strList.add("Apoorva");
        strList.add("Raj");
        strList.add("Adam");
        strList.add("Rahul");
        strList.add("Eve");

        System.out.println("");
        strList.stream().filter(s->s.length()<5).map(s->s.toUpperCase()).forEach(System.out::println);



        //Flattening a stream
        List<List<String>>strList2=new ArrayList<>();
        strList2.add(Arrays.asList("a","b","c"));
        strList2.add(Arrays.asList("d","e","f"));
        strList2.add(Arrays.asList("g","h","i"));
        System.out.println("\n\n"+strList2);

//1. Normal stream
        Stream<List<String>> normalStream = strList2.stream();

//2. Flattening stream
       Stream<String> flattenedStream= normalStream.flatMap(s->s.stream());

//3. FilterOperation
        Stream<String>filteredStream = flattenedStream.filter(s -> s.equals("a"));
        System.out.println("Filtering by using flattenStream :");
        filteredStream.forEach(System.out::println);


    }
}
