package com.Streams.IntermediateOperators;

/*
   # We have 3 SLICING METHODS :
     1. Distinct Method => remove duplicates
     2. Limit => limit max size of stream
     3. Skip
*/

import java.util.ArrayList;
import java.util.List;

public class SlicingOperations {
    public static void main(String[] args) {
        List<String>strList=new ArrayList<>();
        strList.add("Apoorva");
        strList.add("Raj");
        strList.add("Adam");
        strList.add("Rahul");
        strList.add("Apoorva");
        strList.add("Adam");

        //distinct()
        //strList.stream().distinct().forEach(System.out::println);

        //limit
       // strList.stream().limit(2).forEach(System.out::println); //limits the size of stream

        //skip
        strList.stream().limit(3).skip(1).forEach(System.out::println); //limited to size 3 => removed(skipped) first
    }
}
