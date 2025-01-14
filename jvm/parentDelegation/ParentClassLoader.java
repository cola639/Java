public class ParentClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            // Custom logic to load the class, assume class is found
            System.out.println("Parent class loader loading: " + name);
            return SomeClass.class;  // Return the class from the parent
        }
        return super.loadClass(name);  // Delegate to the parent loader
    }
}

public class ChildClassLoader extends ParentClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            // Custom logic to load the class, assume class is found
            System.out.println("Child class loader loading: " + name);
            return SomeClass.class;  // Return the class from the child
        }
        return super.loadClass(name);  // Delegate to the parent class loader
    }
}

public class SomeClass {
    static {
        System.out.println("SomeClass is being loaded.");
    }
}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        ParentClassLoader parentClassLoader = new ParentClassLoader();
        ChildClassLoader childClassLoader = new ChildClassLoader();

        // Try to load the class with the child class loader
        childClassLoader.loadClass("SomeClass");
    }
}
