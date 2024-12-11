package demo2.annoation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // runtime
public @interface MyAnnotation {
    String value() default "Hello";
}
