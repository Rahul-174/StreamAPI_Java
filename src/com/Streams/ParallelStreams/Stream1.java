package com.Streams.ParallelStreams;


import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {
        System.out.println("Printing General Stream");
        Stream.of(1,2,3,4,5,6,7).forEach(num -> System.out.println(num + ", ThreadName:"+ Thread.currentThread().getName()+", ThreadId:"+Thread.currentThread().getId()));
        System.out.println("-------------------------------");
        System.out.println("Parallel Stream");
        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60)
                .parallel()
                .forEach(num -> System.out.println(num + ", ThreadName:"+ Thread.currentThread().getName()+", ThreadId:"+Thread.currentThread().getId()));

        // When to Run Parallel Streams?
        // 1. Splitting is not more expensive than doing the work
        // 2. Tak dispatch/ management costs between the threads is not too high.
        // 3. The result combination cost must not be high.
        // 4. NQ formula :-> N*Q !> 10000 {not more than} (Where N is Number of data items, Q is Amount of work per item)
        /*
        Example: 5 lakhs element -> 20K contains in 1 split -> no. of split 25.
        */


    }
}