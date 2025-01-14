import java.util.Objects;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override hashCode() method
    @Override
    public int hashCode() {
        return Objects.hash(name); // Only use 'name' for hash code calculation
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age; // Compare based on 'age' only
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString() method for better output representation
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class HashCodeEqualsExample {
    public static void main(String[] args) {
        // Create two Person objects with the same 'name' but different 'age'
        Person person1 = new Person("John", 25);
        Person person2 = new Person("John", 30);

        // Check if hashCode() is the same
        System.out.println("HashCode of person1: " + person1.hashCode());
        System.out.println("HashCode of person2: " + person2.hashCode());

        // Check if equals() returns true (it should not because 'age' is different)
        System.out.println("Are person1 and person2 equal? " + person1.equals(person2));
    }
}
