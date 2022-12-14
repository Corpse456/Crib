package com.example.spring2005;

import com.example.spring2005.quoter.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring2005Application {

    public static void main(String[] args) {
        final var context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
    }

}
