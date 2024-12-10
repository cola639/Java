package main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 接口
interface HelloWorld {
    void sayHello();
}

// 真实对象
class HelloWorldImpl implements HelloWorld {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

// 动态代理类
class DynamicProxyExample {
    public static void main(String[] args) {
        HelloWorldImpl helloWorld = new HelloWorldImpl();

        // 创建动态代理
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
                HelloWorld.class.getClassLoader(),
                new Class[] { HelloWorld.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before method: " + method.getName());
                        Object result = method.invoke(helloWorld, args);
                        System.out.println("After method: " + method.getName());
                        return result;
                    }
                }
        );

        proxy.sayHello();  // 代理方法调用
    }
}
