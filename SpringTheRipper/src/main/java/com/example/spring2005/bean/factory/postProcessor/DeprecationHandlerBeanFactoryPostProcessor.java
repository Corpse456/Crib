package com.example.spring2005.bean.factory.postProcessor;

import com.example.spring2005.annotation.DeprecatedClass;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (final String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            final var beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            final var beanClassName = beanDefinition.getBeanClassName();
            final Class<?> beanClass = Class.forName(beanClassName);

            final var annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (annotation != null) {
                beanDefinition.setBeanClassName(annotation.newImpl().getName());
            }
        }
    }
}
