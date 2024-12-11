import java.io.*;

// 1. Define a class that implements Serializable interface
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Version control for Serialization
    private String name;
    private transient int age; // The "transient" keyword prevents the field from being serialized

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method to display the object information
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationExample {

    public static void main(String[] args) {
        // 2. Create an instance of the Person class
        Person person = new Person("John Doe", 30);
        System.out.println("Original Object: " + person);

        // 3. Serialize the object to a file in the current workspace (current directory)
        File file = new File("person.ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(person); // Serialize the object
            System.out.println("Object serialized to " + file.getAbsolutePath() + " in current workspace");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }

        // 4. Deserialize the object from the file in the current workspace (current directory)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Person deserializedPerson = (Person) in.readObject(); // Deserialize the object
            System.out.println("Deserialized Object: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
