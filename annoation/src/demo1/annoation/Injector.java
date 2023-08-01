package demo1.annoation;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Injector {
    public void injectDependencies(Object object) {
            Field[] fields = object.getClass().getDeclaredFields();

            System.out.println(Arrays.toString(fields));

            for (Field field : fields) {
                if (field.isAnnotationPresent(MyAutowired.class)) {
                    field.setAccessible(true);
                    Object dependency = new SomeDependency(); // 简单地创建一个新的SomeDependency实例
                    try {
                        field.set(object, dependency);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}

