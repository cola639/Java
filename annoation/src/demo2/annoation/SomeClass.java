package demo2.annoation;

@MyAnnotation(value = "New Hello")
public class SomeClass {
    public static void main(String[] args) {
        // 获取P1_Basic类上的P1MyAnnotation注解
        MyAnnotation annotation = SomeClass.class.getAnnotation(MyAnnotation.class);
        // 打印value属性值
        System.out.println(annotation.value());
    }
}
