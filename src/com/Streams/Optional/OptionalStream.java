package com.Streams.Optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStream {

    //It is called Wrapper class
        Map<Integer, Person1>personMap =new HashMap<>();

        public Optional<Person1> getPerson(Integer personId){
            return Optional.ofNullable(personMap.get(personId));
        }

    public static void main(String[] args) {
        OptionalStream check =new OptionalStream();


        //some person with some id
        Optional<Person1> obj1 = check.getPerson(32);

        if(obj1.isPresent()){
            System.out.println(obj1.get().getName());
        }else{
            System.out.println("No person found with that ID");
        }



    }
}

//Empty() method => whether optional object does contain a null value
//of() method
//ofNullable() method => use when not sure null or notNUll


class Person1 {
    private String name;
    private int age;
    private String country;

    public Person1() {
    }

    public Person1(String name){
        this.name=name;
    }
    public Person1(String name, int age, String country) {
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
