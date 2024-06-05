import java.util.ArrayList;
import java.util.List;

public class P1Number {
    public static void main(String[] args) {
        P1Number example = new P1Number();
        example.intVsInteger();
    }

    // int VS Integer
    public void intVsInteger() {
        // 1 数值计算
        // int是Java中的基本数据类型之一，用于表示整数值。它是一种原始数据类型，可以直接在内存中存储整数值，因此它具有很高的性能
        int a = 5;
        int b = 10;
        int sum = a + b;
        System.out.println(sum);  // 输出 15

        // 2  数组索引
        int[] arr = {1, 2, 3, 4, 5};
        int index = 2;
        int element = arr[index];
        System.out.println(element);  // 输出 3

        // 3  循环体 int i
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 使用 Integer
        // 1 需要空值：
        // int是一个原始数据类型，它不能表示空值。如果我们需要一个可以为空的整数对象，我们应该使用Integer而不是int
        Integer a1 = null;

        // 2 需要进行包装和拆箱：
        // Integer类提供了将int值包装成对象和从对象中获取int值的方法。这在与其他数据类型进行交互时非常有用
        Integer number = Integer.valueOf(10);
        int value = number.intValue();
        System.out.println(value);  // 输出 10

        // 3 需要使用对象的方法:
        // 需要使用对象的方法：Integer类提供了许多有用的方法，用于处理整数。例如，我们可以使用Integer类的parseInt()方法将字符串转换为整数：
        String str = "123";
        Integer numberMethod = Integer.parseInt(str);
        System.out.println(numberMethod);  // 输出 123

        // 4 泛型参数
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers);  // 输出 [1, 2, 3]
    }
}
