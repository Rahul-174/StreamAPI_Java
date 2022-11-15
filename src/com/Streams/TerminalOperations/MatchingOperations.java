package com.Streams.TerminalOperations;

// lazy operation (take stream and process data and not pass any stream)
// for each is a terminal operation and any last terminal

import com.Streams.Person;

import java.util.ArrayList;
import java.util.List;

public class MatchingOperations {
/*

  Matching Operations Returns Boolean

  1. AnyMatch
     -> if any element match => true
     -> stream is empty => false
     -> if no element match => false

  2. AllMatch
     -> every element match with input => true
     -> stream is empty => true
     -> Any or more element doesn't match => false

  3. NoneMatch
     -> If no element match =>true
     -> stream is empty => true
     -> if any/more element match => false
 */
    public static void main(String[] args) {
        List<Person> peopleList=new ArrayList<>();
        peopleList.add(new Person("Arjun",29,"India"));
        peopleList.add(new Person("Steffie",26,"Dubai"));
        peopleList.add(new Person("Micheal",17,"USA"));
        peopleList.add(new Person("Micheal",16,"UK"));
        peopleList.add(new Person("Adam",27,"France"));

        // 1. Check if any Person belong to India
        boolean ans = peopleList.stream().anyMatch(s->s.getCountry().equals("India"));
        System.out.println("If any Person belong to India ? => " + ans);

        // 2. Check if all persons are less than the age of 30
        boolean ans2 = peopleList.stream().allMatch(s->s.getAge()<30);
        System.out.println("If all persons are less than the age of 30 ? => "+ans2);

        // 3. Check if none of the person name starts with letter Y
        boolean ans3 = peopleList.stream().noneMatch(s->s.getName().startsWith("Y"));
        System.out.println("If none of the person name starts with letter Y ? => "+ans);
    }

}
