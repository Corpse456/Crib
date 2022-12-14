package com.example.spring2005.bean.postProcessor;

import com.example.spring2005.controller.ProfilingController;
import com.example.spring2005.annotation.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Map;

import static java.lang.reflect.Proxy.newProxyInstance;

public class ProfilingHandlingBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> map = new HashMap<>();

    private final ProfilingController controller = new ProfilingController();

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        final Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        final Class<?> beanClass = map.get(beanName);
        if (beanClass != null) {
            return newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), getInvocationHandler(bean));
        }
        return bean;
    }

    private InvocationHandler getInvocationHandler(final Object bean) {
        return (proxy, method, args) -> {
            if (controller.isEnabled()) {
                System.out.println("-------ProfilingHandlingBeanPostProcessor.postProcessAfterInitialization---------");
                System.out.println("Профилирую...");
                final var before = System.nanoTime();
                final var returnedValue = method.invoke(bean, args);
                System.out.println(System.nanoTime() - before);
                System.out.println("Готово");
                System.out.println("---------------------------------------------------------------------------------");
                return returnedValue;
            } else {
                return method.invoke(bean, args);
            }
        };
    }
}
