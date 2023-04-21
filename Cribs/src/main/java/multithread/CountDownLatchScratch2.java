package multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchScratch2 {

    private static Integer counter1 = 0;

    private static Integer counter2 = 0;

    private static final AtomicInteger counter11 = new AtomicInteger(0);

    private static final AtomicInteger counter22 = new AtomicInteger(0);

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int taskCount = 100_000_000;
        runProgram(taskCount, CountDownLatchScratch2::extracted3, counter1, counter2);
        runProgram(taskCount, CountDownLatchScratch2::extracted2, counter11, counter22);
        counter1 = 0;
        counter2 = 0;
        runProgram(taskCount, CountDownLatchScratch2::extracted, counter1, counter2);
        System.exit(0);
    }

    private static void runProgram(final int taskCount, Runnable extractor, Object counter1, Object counter2)
            throws InterruptedException {
        final var startTime = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(taskCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < taskCount; i++) {
            executor.submit(() -> {
                extractor.run();
                latch.countDown();
            });
        }

        latch.await();

        System.out.println("counter1 = " + counter1);
        System.out.println("counter2 = " + counter2);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
    }

    private static void extracted() {
        try {
            lock.lock();
            counter1++;
            counter2++;
        } finally {
            lock.unlock();
        }
    }

    private static void extracted3() {
        synchronized (CountDownLatchScratch.class) {
            counter1++;
            counter2++;
        }
    }

    private static void extracted2() {
        counter11.incrementAndGet();
        counter22.incrementAndGet();
    }
}
