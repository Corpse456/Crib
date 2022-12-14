package com.example.spring2005.bean.postProcessor;

import com.example.spring2005.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        final var fields = bean.getClass().getDeclaredFields();
        for (final Field field : fields) {
            final var annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                final var min = annotation.min();
                final var max = annotation.max();
                final var random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }
        }
        System.out.println("\n-------------------------postProcessBeforeInitialization------------------------------");
        System.out.println("--------------------------------------------------------------------------------------\n");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        System.out.println("\n-------------------------postProcessAfterInitialization-------------------------------");
        System.out.println("--------------------------------------------------------------------------------------\n");
        return bean;
    }
}
