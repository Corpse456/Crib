package multithread;

import java.util.concurrent.CyclicBarrier;

class CyclicBarrierScratch {

    public static void main(String[] args) throws InterruptedException {
        final var cyclicBarrier = new CyclicBarrier(10, new Run());
        for (int i = 1; i < 11; i++) {
            new Sportsman(cyclicBarrier, i);
            Thread.sleep(3000);
        }
        System.out.println("Main done");
    }

    static class Run extends Thread {

        @Override
        public void run() {
            System.out.println("Run has began");
        }
    }

    static class Sportsman extends Thread {

        private final CyclicBarrier cyclicBarrier;

        public Sportsman(final CyclicBarrier cyclicBarrier, final int number) {
            this.cyclicBarrier = cyclicBarrier;
            System.out.println("Added sportsman " + number);
            setName("Sportsmen" + number);
            start();
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println(this.getName() + " has started the race");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
