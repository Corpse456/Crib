package com.example.spring2005.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) public @interface DeprecatedClass {

    Class<?> newImpl();
}
