import java.io.*;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class ThrowAndThrowsExample {

    // Method that declares it can throw an exception using 'throws'
    public static void riskyMethod() throws IOException, MyException {
        // Simulating a risky operation that can throw exceptions
        throw new IOException("An IO error occurred");
    }

    // Method that demonstrates how 'throw' works to actually throw an exception
    public static void throwExample() throws MyException {
        // Throwing a custom exception explicitly
        throw new MyException("This is a custom exception");
    }

    public static void main(String[] args) {
        try {
            // Calling a method that declares exceptions with 'throws'
            riskyMethod();  // Can throw IOException or MyException

        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());

        } catch (MyException e) {
            System.out.println("Caught MyException: " + e.getMessage());
        }

        try {
            // Calling a method that throws a custom exception with 'throw'
            throwExample();  // This method explicitly throws MyException

        } catch (MyException e) {
            System.out.println("Caught MyException: " + e.getMessage());
        }
    }
}
