package wg.kafka.avro.reflection;

import org.apache.avro.reflect.Nullable;

public class CustomerForReflection {

    private String firstName;
    private String lastName;
    @Nullable
    private int age;

    // for reflection
    public CustomerForReflection() {
    }

    public CustomerForReflection(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
