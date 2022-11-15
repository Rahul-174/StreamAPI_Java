package com.Streams.Collectors;


/*
    The collect() method in Stream API collects all objects from a stream object and stored in the type of collection.
    The user has to provide what type of collection the results can be stored. We specify the collection type using the Collectors Enum.
    There are different types and different operations can be present in the Collectors Enum,
    but most of the time we can use:
            -> Collectors.toList(),
            -> Collectors.toSet(),
            -> Collectors.toMap().
*/

import java.util.*;
import java.util.stream.Collectors;

public class CollectionOperations {
    public static void main(String[] args) {
        //1. Collect Method
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Rahul",29,34234,"India"));
        persons.add(new Person("Apoorva",34,23557,"Dubai"));
        persons.add(new Person("Rohit",45,56222,"UK"));
        persons.add(new Person("Kalyan",59,23412,"India"));
        persons.add(new Person("Jitendra",69,34222,"Australia"));
        persons.add(new Person("Manish",79,23412,"UK"));

        //List
        List<String>personNames = persons.stream().map(p->p.getName()).collect(Collectors.toList());
        System.out.println("List Of Names : "+ personNames);

        //Set
        Set<String> uniqueName = persons.stream().map(p->p.getName()).collect(Collectors.toSet());
        System.out.println("Set Of Names (Unique names in the list ) : "+uniqueName);

        // Linked List
        LinkedList<String> llnamePerson = persons.stream().map(s -> s.getName()).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("ll Person Name: "+llnamePerson);

        // TreeSet
        TreeSet<String> tsnamePerson = persons.stream().map(s -> s.getName()).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("ts Person Name: "+tsnamePerson);

        // ArrayList
        ArrayList<String> alnamePerson = persons.stream().map(s -> s.getName()).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("al Person Name: "+alnamePerson);


        // Map
        Map<String,Integer> mapnamePerson = persons.stream().collect(Collectors.toMap(s->s.getName(),s->s.getSalary()));
        System.out.println("Map Person Name with Salary: "+mapnamePerson);

        // Downstream

        List<String> notChangableList = persons.stream().map(s-> s.getName()).collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
        System.out.println("Not changable list" + notChangableList);

        // Error
        // => notChangableList.add();
        /*
        java: no suitable method found for add(no arguments)
            method java.util.List.add(java.lang.String) is not applicable
              (actual and formal argument lists differ in length)
            method java.util.List.add(int,java.lang.String) is not applicable
              (actual and formal argument lists differ in length)
         */
    }
}

