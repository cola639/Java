package org.example;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavassistProxyExample {

    public static void main(String[] args) throws Exception {
        // 获取默认的类池
        ClassPool pool = ClassPool.getDefault();

        // 获取 Main 类的完整包名（假设 Main 类位于 org.example 包中）
        CtClass ctClass = pool.get("org.example.Main");  // 使用完整的类名

        // 获取 main 方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("main");

        // 在调用方法前后插入代码
        ctMethod.insertBefore("{ System.out.println(\"Before method: main\"); }");
        ctMethod.insertAfter("{ System.out.println(\"After method: main\"); }");

        // 创建一个新的实例并调用 main 方法
        Class<?> clazz = ctClass.toClass();

        // 使用静态方法的调用方式
        clazz.getDeclaredMethod("main", String[].class).invoke(null, (Object) args);  // 这里传入 null，因为是静态方法
    }
}
