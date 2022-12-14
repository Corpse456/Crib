package com.example.spring2005.bean.factory.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class TerminatorQuoterBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("\n-------------BeanFactoryPostProcessor----------------------");
        final var beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (final String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        beanFactory.getBeanDefinition("terminatorQuoter").setScope(BeanDefinition.SCOPE_SINGLETON);
        System.out.println("-----------------------------------------------------------\n");
    }
}
