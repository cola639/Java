### Generics in Java

Generics in Java are a powerful feature that allows you to write more flexible and reusable code. They enable you to
define classes, interfaces, and methods with a placeholder for the type they operate on. Here is a comprehensive
overview of generics:

#### 1. **Basic Syntax**

A generic type is a class or interface that is parameterized over types. The most commonly used type parameter names
are:

- `E` - Element (used extensively by the Java Collections Framework)
- `K` - Key
- `N` - Number
- `T` - Type
- `V` - Value
- `S`, `U`, `V`, etc. - 2nd, 3rd, 4th types

Example of a generic class:

```java
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
```

You can use the `Box` class with different types:

```java
Box<Integer> integerBox = new Box<>();
Box<String> stringBox = new Box<>();
```

#### 2. **Generic Methods**

Generic methods are methods that introduce their own type parameters. This is particularly useful for static methods, as
they cannot access the class’s type parameters.

```java
public class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
```

You can call this method with different types of arrays:

```java
Integer[] intArray = {1, 2, 3, 4};
String[] stringArray = {"A", "B", "C"};

Util.printArray(intArray);
Util.printArray(stringArray);
```

#### 3. **Bounded Type Parameters**

You can restrict the types that can be used as type arguments with bounded type parameters. The bounds can be either
upper or lower.

**Upper Bounded Type Parameter:**

```java
public <T extends Number> void inspect(T t) {
    System.out.println(t.getClass().getName());
}
```

**Lower Bounded Type Parameter:**

```java
public static void addNumbers(List<? super Integer> p1_list) {
    p1_list.add(new Integer(50));
}
```

#### 4. **Wildcards**

Wildcards are represented by the `?` symbol and can be used in three ways:

**Unbounded Wildcards:**

```java
public void printList(List<?> p1_list) {
    for (Object elem : p1_list) {
        System.out.println(elem);
    }
}
```

**Upper Bounded Wildcards:**

```java
public void processElements(List<? extends Number> p1_list) {
    for (Number n : p1_list) {
        System.out.println(n.doubleValue());
    }
}
```

**Lower Bounded Wildcards:**

```java
public void addNumbers(List<? super Integer> p1_list) {
    p1_list.add(new Integer(10));
}
```

#### 5. **Generic Interfaces**

Interfaces can also be generic, which allows for flexible implementations:

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
```

Example implementation:

```java
public class OrderedPair<K, V> p2_implements Pair

<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey () {
        return key;
    }
    public V getValue () {
        return value;
    }
}
```

#### 6. **Type Erasure**

Java generics use a feature called type erasure to maintain backward compatibility with older versions of Java. This
means that the generic type information is only available at compile time and is erased at runtime.

```java
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

// At runtime, this class is equivalent to:
public class Box {
    private Object t;

    public void set(Object t) {
        this.t = t;
    }

    public Object get() {
        return t;
    }
}
```

#### 7. **Best Practices**

- Use meaningful type parameter names.
- Avoid using raw types.
- Use bounded wildcards to increase API flexibility.
- Prefer `List<E>` over `E[]` to avoid issues with type safety and type erasure.

Generics provide a way to ensure type safety and reduce the risk of `ClassCastException` at runtime. They also enable
you to write more generic and reusable code.