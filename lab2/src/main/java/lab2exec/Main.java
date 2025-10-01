package lab2exec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder().firstName("John").lastName("Doe").age(30).build();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        var json = gson.toJson(person);
        System.out.println(json);

        Person personToCompare = gson.fromJson(json, Person.class);

        System.out.println("Objects equal:  " + person.equals(personToCompare));
    }
}
