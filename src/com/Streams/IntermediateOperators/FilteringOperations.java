package com.Streams.IntermediateOperators;

import com.Streams.Person;

import java.util.ArrayList;
import java.util.List;

public class FilteringOperations {
    public static void main(String[] args) {
        //List of Integers
        List<Integer> intList = new ArrayList<>();
        intList.add(12);
        intList.add(23);
        intList.add(1);
        intList.add(2);
        intList.add(10);
        intList.add(11);

        System.out.println("Filter elements (ele>2 and <20) from the list using stream : ");
        intList.stream().filter(s->s>2).forEach(System.out::println);
        /*
            Here :
                1. intList.stream() -> created stream of the ArrayList "intList"
                2. intList.stream().filter(s->s>2) -> from the created list filtering element >2
                3. {}.forEach(System.out::println) -> printing each of the filtered element
         */

        //Multiple conditions inside filter
        System.out.println("\nMultiple conditions inside filter (ele>2 and <20) : ");
        intList.stream().filter(s -> s>2 && s<20).forEach(System.out::println);

        // NOTE => It doesn't affect the original data structure
        //checking original Data structure
        System.out.println("\nchecking original Data structure");
        intList.stream().forEach(s-> System.out.println(s));



//CREATE A PERSON CLASS INSIDE STREAMS PACKAGE WITH FIELDS name,age,country

// 1. USE STREAMS TO FIND PEOPLE ELIGIBLE FOR VOTING(age>=18)

        List<Person>peopleList=new ArrayList<>();
        peopleList.add(new Person("Rahul",24,"India"));
        peopleList.add(new Person("Apoorva",26,"Nepal"));
        peopleList.add(new Person("Akash",17,"Bangladesh"));
        peopleList.add(new Person("Raj",16,"India"));
        peopleList.add(new Person("Kalyan",27,"Pakistan"));
        peopleList.add(new Person("Dinesh",67,"India"));
        peopleList.add(new Person("Mangesh",37,"India"));

        System.out.println("\n\nPersons eligible for voting are : ");
//      peopleList.stream().filter(p->p.getAge()>=18).forEach(System.out::println); //Printing all details of persons at once
        peopleList.stream().filter(p->p.getAge()>=18).forEach(s-> System.out.println("Name :"+ s.getName()+", Age :"+s.getAge())); //Printing only names


//CHAINABLE FILTER :
// 2. USE STREAMS TO FIND PEOPLE FROM INDIA AND BELOW RETIREMENT AGE(<60) Using Chainable filter

        System.out.println("\n\nPeople From India and below 60 :");
        peopleList.stream().filter(s->s.getCountry().equals("India")).filter(s->s.getAge()<60).forEach(s-> System.out.println("Name:"+ s.getName()+", Age:"+s.getAge()+", Country:"+s.getCountry()));





    }

}
