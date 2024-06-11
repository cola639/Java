// A generic type is a class or interface that is parameterized over types. The most commonly used type parameter names are:
// Basic Syntax
//  - `E` - Element (used extensively by the Java Collections Framework)
// - `K` - Key
// - `N` - Number
// - `T` - Type
// - `V` - Value
// - `S`, `U`, `V`, etc. - 2nd, 3rd, 4th types
// Parameter Generic
public class P1GenericBasic<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        P1GenericBasic<Integer> integerP1GenericBasic = new P1GenericBasic<Integer>();    // 定义泛型为Integer类型
        P1GenericBasic<String> stringP1GenericBasic = new P1GenericBasic<String>();       // 定义泛型为String类型

        integerP1GenericBasic.add(new Integer(10));
        stringP1GenericBasic.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n\n", integerP1GenericBasic.get());
        System.out.printf("字符串为 :%s\n", stringP1GenericBasic.get());
    }
}