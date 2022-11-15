package com.Streams.immutabaleOperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// Result of Reduction operations are immutable => Not changable
/*
    TERMS :
    Reduce => Collection of Object => Gives a Single Valued Result which is Immutable
    Identity => Initial value of the operation => default result => when your stream is empty
    Accumulator => a,b => a[partial result] +b [next element of the stream]
    Combiner => types of accumulator implementation


    METHODS:
    1. Optional<T>reduce(BinaryOperator<T>accumulator)
    2. T reduce(T identity, BinaryOperator<T>accumulator)
    3. Combiner with Parallel Streams
    4. Max and Min => First sort than return max at natural order and min at reverse order

    T in java represents Type
*/


public class ReductionOperations {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Rahul",29,44000));
        persons.add(new Person("Apoorva",34,34000));
        persons.add(new Person("Rohit",45,44000));
        persons.add(new Person("Kalyan",59,54000));
        persons.add(new Person("Jitendra",69,64000));
        persons.add(new Person("Manish",79,74000));

       // 1. Optional<T>reduce(BinaryOperator<T>accumulator)

        int totalslry=persons.stream().mapToInt(s->s.getSalary()).sum();
        System.out.println("Total Salary without reduce : "+totalslry);
        //We don't normally use this when we have huge amount of data :
        // b/c as it first converts stream and then mapsToInt -> double process

        Optional<Integer>totalSalary = persons.stream().map(s->s.getSalary()).reduce((p,q)->p+q);
        if(totalSalary.isPresent()){
            System.out.println("Total Salary of all : "+ totalSalary+" -> "+totalSalary.get());
        }else{
            System.out.println("No Records present");
        }

//__________________________________________________________________________________
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        // 2. T reduce(T identity, BinaryOperator<T>accumulator)
        // It takes as identity as default value and adds the list values in it,
        // hence if list is empty it returns identity
        int totalSum = intList.stream().reduce(10,(p1,n)->p1+n);
        System.out.println("10 added to TotalSum : "+totalSum);

//______________________________________________________________________________________

        // 3. Combiner with Parallel Streams

        /*
             Stream -> 1.1 Stream -> 1.2 Stream -> 1.3 Stream => three parallel stream
             Stream -> Payroll[Jan + Feb + Mar] Combiner
             Sub Streams -> Jan[Sub] -> Number of Days -> Feb[Sub] -> Number of Days-> Mar[Sub] -> Number of Days.
         */
        int totalSum2=intList.parallelStream().reduce(10,(partialSum,n)->partialSum+n,Integer::sum);
        //combiner(here Integer::sum) waits for all streams to finish

//___________________________________________________________________________________
        // 4. Max and Min => First sort than return max at natural order and min at reverse order
        // Natural Order last node => 0->1->2->3 => 3
        // Reverse Order fist node => 0->1->2->3 => 0

        /*
            natural order + max -> last value(automatically it will be max)
            natural order + min -> first value(automatically it will be min)

            reverse order + max -> last value(automatically it will be min)
            revers order + min -> first value(automatically it will be max)
        */

        Optional<Integer> maxNum=intList.stream().max(Comparator.naturalOrder());
        System.out.println(maxNum.get());

        Optional<Integer> maxNum1=intList.stream().min(Comparator.reverseOrder());
        System.out.println(maxNum1.get());

    }
}

class Person {
    String name;
    int age;
    int salary;

    public Person(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "Person{"+
                "Name:'"+name+'\''+
                ", Age:"+age+
                ", Salary:"+salary+
                "}";
    }


}
