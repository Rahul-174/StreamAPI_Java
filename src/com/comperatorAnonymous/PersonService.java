package com.comperatorAnonymous;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {
    public static List<Person> getPerson(List<Person> persons){
        // Anonymous Class Approach, Comparator is anonymous class
//       Collections.sort(persons,new Comparator<Person>(){
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });




        // Using Lambda Expression (Memorisation technique) , compare old value with new one.
        Collections.sort(persons, (o1,o2) -> o1.getName().compareTo(o2.getName()));
        return persons;
    }
}
