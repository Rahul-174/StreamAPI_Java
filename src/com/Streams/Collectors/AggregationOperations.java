package com.Streams.Collectors;



// Aggregate Operation is real Operation

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AggregationOperations {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Rahul",29,34234,"India"));
        persons.add(new Person("Apoorva",34,23557,"Dubai"));
        persons.add(new Person("Rohit",45,56222,"UK"));
        persons.add(new Person("Kalyan",59,23412,"India"));
        persons.add(new Person("Jitendra",69,34222,"Australia"));
        persons.add(new Person("Manish",79,23412,"UK"));


        //counting
        long count = persons.stream().filter(emp -> emp.getAge()>35).collect(Collectors.counting());
        System.out.println("Number of people wit age>35 : "+count);

        // Summing
        long totalSalary = persons.stream().collect(Collectors.summingLong(p->p.getSalary()));
        System.out.println("Total Salary: "+totalSalary);

        // Avg
        double averageSalary = persons.stream().collect(Collectors.averagingInt(p->p.getSalary()));// Salary in double
        double DoubleAverageSalary = persons.stream().collect(Collectors.averagingLong(p->p.getSalary()));// Salary in double
        System.out.println("Avg Salary: "+averageSalary);
        System.out.println("Avg Salary  Double: "+DoubleAverageSalary);

        //minBy
        Optional<Person> minSalaryPerson = persons.stream().collect(Collectors.minBy(Comparator.comparing(Person::getSalary)));
        System.out.println("Person with minSalary:"+minSalaryPerson);

        //Person less than 30 and min Salary
        Optional<Person>minSalaryPersonLessThan30 = persons.stream().filter(p->p.getAge()<30).collect(Collectors.minBy(Comparator.comparing(Person::getSalary)));
        System.out.println(minSalaryPersonLessThan30);

        //maxBy
        Optional<Person>maxSalaryPerson = persons.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getSalary)));
        System.out.println("Person with maxSalary:"+maxSalaryPerson.get());
//
//        // Joining
//        String JoinAString = Stream.of("I","am","Arjun").collect(Collectors.joining(" "));
//        System.out.println(JoinAString);

        // Joining Object Specific String Variable
        String JoinAStringName = persons.stream().map(emp -> emp.getName()).collect(Collectors.joining(", "));
        System.out.println(JoinAStringName);



    }

}
