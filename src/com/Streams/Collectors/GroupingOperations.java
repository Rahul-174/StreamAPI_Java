package com.Streams.Collectors;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingOperations {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Rahul",29,34234,"India"));
        persons.add(new Person("Apoorva",34,23557,"Dubai"));
        persons.add(new Person("Rohit",45,56222,"UK"));
        persons.add(new Person("Kalyan",45,23412,"India"));
        persons.add(new Person("Jitendra",69,34222,"Australia"));
        persons.add(new Person("Manish",29,23412,"UK"));

        // GroupBy Age
        Map<Integer,List<Person>> listMap = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Group By Age List :\n"+listMap);

        //groupByCountryName
        Map<String,List<Person>> groupByCountryName = persons.stream().collect(Collectors.groupingBy(Person::getCountry));
        System.out.println("\n\nGroup By Country Name List :\n"+groupByCountryName);

        // GroupBy Country with Single Max Salary Person.
        Map<String, Optional<Person>> listMap_SinglePersonWithMaxSalary = persons.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.maxBy(Comparator.comparingInt(Person::getSalary))));
        System.out.println("\nlistMap_SinglePersonWithMaxSalary : \n"+listMap_SinglePersonWithMaxSalary);


    }
}
