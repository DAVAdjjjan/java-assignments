package lab2exec;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if(!(o instanceof Person person)) return false;

        return
                Objects.equals(person.firstName, this.firstName) &&
                        Objects.equals(person.lastName, this.lastName) &&
                        person.age == this.age;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
