package com.example.spring2005.quoter;

import com.example.spring2005.annotation.DeprecatedClass;
import com.example.spring2005.annotation.InjectRandomInt;
import com.example.spring2005.annotation.PostProxy;
import com.example.spring2005.annotation.Profiling;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Setter;

import java.util.Random;

@Data
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    @Setter
    @InjectRandomInt(min = 2, max = 5)
    private int repeat;

    private String message;

    private int randomInt = new Random().nextInt();

    @PostConstruct
    public void init() {
        System.out.println("\n-------------------------Init------------------------------");
        System.out.println("repeat = " + repeat);
        System.out.println("message = " + message);
        System.out.println("-----------------------------------------------------------\n");
    }

    public TerminatorQuoter() {
        System.out.println("\n--------------------Constructor----------------------------");
        System.out.println("repeat = " + repeat);
        System.out.println("message = " + message);
        System.out.println("-----------------------------------------------------------\n");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("---------------Say quote method----------------------------");
        System.out.println("randomInt = " + randomInt);
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
        System.out.println("-----------------------------------------------------------");
    }
}
