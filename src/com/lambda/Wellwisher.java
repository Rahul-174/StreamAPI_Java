package com.lambda;

public class Wellwisher {
    public static void sayHello(Language language) {
        language.wish();
    }

    public static void main(String[] args) {
//        Language englishObj = new English();
//        sayHello(englishObj);
//
//        Language hindiObj = new Hindi();
//        sayHello(hindiObj);
//
//        Language marathiObj = new Marathi();
//        sayHello(marathiObj);




      //Anonymous class objects
//        sayHello(new Language() {
//            @Override
//            public void wish() {
//                System.out.println("Namaskar");
//            }
//        });
//        sayHello(new Language() {
//            @Override
//            public void wish() {
//                System.out.println("Hello how are you?");
//            }
//        });



       //We don't need classes English, Hindi,Marathi
       //Lambda functions
        sayHello( () -> System.out.println("Kaise ho ap?"));

        sayHello(()-> System.out.println("Hello how are you?"));

        sayHello(()-> System.out.println("Namaskar"));
    }
}
