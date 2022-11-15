package com.Streams.TerminalOperations;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindingOperations {

    //FindFirst
    //FindAny

    public static void main(String[] args) {
        List<Person2> peopleList=new ArrayList<>();
        peopleList.add(new Person2("abc",10,"AUS"));
        peopleList.add(new Person2("Micheal",17,"US"));
        peopleList.add(new Person2("Micheal",16,"UK"));
        peopleList.add(new Person2("Adam",27,"France"));
        peopleList.add(new Person2("sefsdv",136,"UK"));


        Optional<Person2> p =peopleList.stream()
                .filter(s->s.getCountry().equals("UK"))
                .findFirst();
        if(p.isPresent()){
            System.out.println(p);
        }else{
            System.out.println("No records");
        }

    }
}


class Person2 {
    private String name;
    private int age;
    private String country;

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public Person2(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}