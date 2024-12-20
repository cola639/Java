### 什么是 Lambda 表达式？

Lambda 表达式是 Java 8 引入的一个新特性，它是一种可以在代码中直接传递的匿名函数。通过 Lambda 表达式，我们可以用更简洁的方式表达函数式接口的实现。

**Lambda 表达式的基本语法**：
```java
(parameters) -> expression
```
- `parameters`: 表示输入的参数，通常是方法的参数列表。
- `->`:  Lambda 运算符，将输入参数与 Lambda 体分开。
- `expression`: Lambda 表达式的实现部分，可以是一个简单的表达式或者代码块。

### 1. **Lambda 示例 - 无参数**

一个最简单的 Lambda 表达式，没有参数且执行一个简单的操作。

**代码示例**：
```java
public class LambdaExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式实现 Runnable 接口
        Runnable run = () -> System.out.println("Hello, Lambda!");
        run.run(); // 输出: Hello, Lambda!
    }
}
```
**解释**：
- `Runnable` 接口只有一个 `run()` 方法，它没有参数，返回类型是 `void`。
- 使用 Lambda 表达式 `() -> System.out.println("Hello, Lambda!")` 替代了匿名内部类的实现。

### 2. **Lambda 示例 - 带参数**

Lambda 表达式可以接收参数并执行某些操作。以下示例演示了如何传递参数并使用 Lambda 表达式实现一个简单的函数式接口。

**代码示例**：
```java
public class LambdaExample {
    public static void main(String[] args) {
        // 使用 Lambda 表达式实现一个接口
        // 定义一个接受两个整数并返回它们和的接口
        Adder add = (a, b) -> a + b;
        
        // 调用方法
        System.out.println(add.add(5, 3));  // 输出: 8
    }
}

// 定义一个函数式接口
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}
```
**解释**：
- `Adder` 是一个函数式接口，只有一个抽象方法 `add()`，接收两个参数并返回它们的和。
- `add = (a, b) -> a + b;` 使用 Lambda 表达式实现了该接口。

### 3. **Lambda 示例 - 使用集合**

Lambda 表达式在集合操作中非常有用，特别是与 `Stream` API 配合使用。以下示例演示了如何使用 Lambda 表达式对集合中的元素进行操作。

**代码示例**：
```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        // 创建一个列表
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");

        // 使用 Lambda 表达式打印出每个名字
        names.forEach(name -> System.out.println(name));
    }
}
```
**解释**：
- `forEach` 是 `List` 接口的方法，它接受一个 `Consumer` 函数式接口作为参数。
- `name -> System.out.println(name)` 使用 Lambda 表达式来实现 `Consumer` 接口的 `accept()` 方法。

### 4. **Lambda 示例 - 复杂操作**

Lambda 表达式还可以进行更复杂的操作，如过滤、排序等。以下是使用 `Stream` API 和 Lambda 表达式对集合进行排序和过滤的示例。

**代码示例**：
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {
    public static void main(String[] args) {
        // 创建一个字符串列表
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");

        // 使用 Lambda 表达式过滤并排序
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("J"))  // 过滤以 "J" 开头的名字
                                          .sorted()  // 排序
                                          .collect(Collectors.toList());  // 收集成新的列表

        System.out.println(filteredNames);  // 输出: [Jane, John]
    }
}
```
**解释**：
- `filter(name -> name.startsWith("J"))`：筛选出所有以字母 "J" 开头的名字。
- `sorted()`：对结果进行排序。
- `collect(Collectors.toList())`：将结果收集到一个新的列表中。

### 5. **Lambda 示例 - 方法引用**

Lambda 表达式还可以与方法引用结合使用。方法引用是 Lambda 表达式的一个简化版本，允许直接引用现有方法。

**代码示例**：
```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        // 创建一个字符串列表
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");

        // 使用方法引用代替 Lambda 表达式
        names.forEach(System.out::println);  // 输出每个名字
    }
}
```
**解释**：
- `System.out::println` 是一个方法引用，等价于 `name -> System.out.println(name)`。
- 方法引用使得代码更加简洁。

### 总结：

- **Lambda 表达式**使得 Java 代码更加简洁和易读，特别是与集合和 `Stream` API 一起使用时。
- 它可以代替匿名内部类，并实现函数式接口。
- `->` 运算符是 Lambda 表达式的标志，帮助将参数与方法体分开。
- **方法引用** (`ClassName::methodName`) 是 Lambda 表达式的一种简化形式。

希望这些例子能帮助你更好地理解 Java 中的 Lambda 表达式！