package com.comperatorAnonymous;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Manish",22,"India"));
        persons.add(new Person("Ravi",29,"India"));
        persons.add(new Person("Kusum",24,"India"));
        persons.add(new Person("Zoya",18,"London"));
        persons.add(new Person("Maya",23,"UK"));

        int Index=0;
        for(Person person:persons){
            Index++;
            System.out.println("Index-"+Index+", Unsorted: "+person.getName());
        }

        // getPerson Function
        List<Person> sortedPersons = PersonService.getPerson(persons);
        System.out.println(" ");
        Index=0;
        for(Person person:sortedPersons){
            Index++;
            System.out.println("Index-"+Index+", sorted: "+person.getName());
        }
    }
}
