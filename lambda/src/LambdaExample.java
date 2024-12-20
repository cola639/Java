import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 定义一个函数式接口
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {

        // 1 使用 Lambda 表达式实现 Runnable 接口
        Runnable run = () -> System.out.println("Hello, Lambda!");
        run.run(); // 输出: Hello, Lambda!

        // 2 使用 Lambda 表达式实现一个接口
        // 定义一个接受两个整数并返回它们和的接口
        Adder add = (a, b) -> a + b;
        System.out.println(add.add(5, 3));  // 输出: 8

        // 3 使用 Lambda 表达式打印出每个名字
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eva");
        names.forEach(name -> System.out.println(name));
        // 使用方法引用代替 Lambda 表达式 输出每个名字
        names.forEach(System.out::println);

        // 4 使用 Lambda 表达式过滤并排序
        List<String> sortNames = Arrays.asList("John", "Jane", "Adam", "Eva");
        List<String> filteredNames = sortNames.stream()
                .filter(name -> name.startsWith("J"))  // 过滤以 "J" 开头的名字
                .sorted()  // 排序
                .collect(Collectors.toList());  // 收集成新的列表

        System.out.println(filteredNames);  // 输出: [Jane, John]

    }
}
