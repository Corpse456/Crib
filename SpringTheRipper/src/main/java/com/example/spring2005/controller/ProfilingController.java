package com.example.spring2005.controller;

public class ProfilingController {

    private boolean enabled = true;

    public ProfilingController() {
        //        final var newThread = new Thread(() -> {
        //            while (true) {
        //                enabled = !enabled;
        //                try {
        //                    Thread.sleep(10000);
        //                } catch (InterruptedException e) {
        //                    throw new RuntimeException(e);
        //                }
        //            }
        //        });
        //        newThread.start();
    }

    public boolean isEnabled() {
        return enabled;
    }
}
