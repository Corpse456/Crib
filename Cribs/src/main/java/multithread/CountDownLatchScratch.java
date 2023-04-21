package multithread;

import java.util.concurrent.CountDownLatch;

class CountDownLatchScratch {

    public static void main(String[] args) throws InterruptedException {
        final var countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();
        System.out.println("All done");
    }
}

class Work extends Thread {

    private final CountDownLatch countDownLatch;

    public Work(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        countDownLatch.countDown();
    }
}
