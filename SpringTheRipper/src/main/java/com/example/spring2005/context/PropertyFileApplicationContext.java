package com.example.spring2005.context;

import com.example.spring2005.quoter.Quoter;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        final var reader = new PropertiesBeanDefinitionReader(this);
        final var beansCount = reader.loadBeanDefinitions(fileName);
        System.out.println("Found " + beansCount + " beans");
        refresh();
    }

    public static void main(String[] args) {
        final var context = new PropertyFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
