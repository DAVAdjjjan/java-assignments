import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lab2exec.Person;

public class PersonEq {

    @Test
    public void TestIfEqualIdenticalObjects() {
        Person person = Person.builder().firstName("John").lastName("Doe").age(30).build();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        var json = gson.toJson(person);

        Person personToCompare = gson.fromJson(json, Person.class);

        assertTrue(person.equals(personToCompare));
    }

    @Test
    public void TestIfNotEqualDifferentObjects() {
        Person person = Person.builder().firstName("John").lastName("Doe").age(30).build();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        var json = gson.toJson(person);

        person.setAge(10);

        Person personToCompare = gson.fromJson(json, Person.class);


        assertFalse(person.equals(personToCompare));
   }
}
