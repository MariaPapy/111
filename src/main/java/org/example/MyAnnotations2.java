package org.example;

import java.lang.annotation.*;


@Repeatable(MyAnnotation2.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyAnnotations2 {
    int hour();
    int priority();
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface MyAnnotation2 {
    MyAnnotations2[] value();
}

