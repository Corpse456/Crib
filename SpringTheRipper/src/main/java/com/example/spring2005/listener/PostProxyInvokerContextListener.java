package com.example.spring2005.listener;

import com.example.spring2005.annotation.PostProxy;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    @SneakyThrows
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final var context = event.getApplicationContext();
        final var beanDefinitionNames = context.getBeanDefinitionNames();
        for (final String beanDefinitionName : beanDefinitionNames) {
            final var beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            final var originalBeanClassName = beanDefinition.getBeanClassName();
            final Class<?> originalClass = Class.forName(originalBeanClassName);
            final var methods = originalClass.getMethods();
            for (final Method method : methods) {
                if (method.isAnnotationPresent(PostProxy.class)) {
                    final var bean = context.getBean(beanDefinitionName);
                    final var currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    System.out.println("\n-------------PostProxyInvokerContextListener---------------");
                    currentMethod.invoke(bean);
                    System.out.println("-----------------------------------------------------------\n");
                }
            }
        }
    }
}
