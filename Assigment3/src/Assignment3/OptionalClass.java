package Ass3;

import java.util.Optional;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}

public class OptionalClass {
    public static void main(String[] args) {
        
        Person personWithName = new Person("Deepthi");
        
       
        String name = personWithName.getName().orElse("Unknown");
        System.out.println("Name: " + name);

     
        if (personWithName.getName().isPresent() && personWithName.getName().get().equalsIgnoreCase("Deepthi")) {
            System.out.println("Name is equal to Deepthi");
        } else {
            System.out.println("Name is not equal to Deepthi");
        }
  
        Person personWithoutName = new Person(null);

        String noName = personWithoutName.getName().orElse("No Name Provided");
        System.out.println("Name: " + noName);
    }
}