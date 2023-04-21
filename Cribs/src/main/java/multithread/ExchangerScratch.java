package multithread;

import java.util.concurrent.Exchanger;

class ExchangerScratch {

    public static void main(String[] args) {
        final var exchanger = new Exchanger<String>();
        new Mark(exchanger);
        new Antoniy(exchanger);
    }

    static class Mark extends Thread {

        private final Exchanger<String> exchanger;

        public Mark(final Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            setName("Mark");
            start();
        }

        @Override
        public void run() {
            try {
                final var hello = exchanger.exchange("Hello, I'm " + this.getName());
                System.out.println("hello = " + hello);
                sleep(3000);
                System.out.println(exchanger.exchange("Fuck you"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Antoniy extends Thread {

        private final Exchanger<String> exchanger;

        public Antoniy(final Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            setName("Antoniy");
            start();
        }

        @Override
        public void run() {
            try {
                sleep(3000);
                System.out.println(exchanger.exchange("Hello, I'm " + this.getName()));
                sleep(3000);
                System.out.println(exchanger.exchange("Fuck you self"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
