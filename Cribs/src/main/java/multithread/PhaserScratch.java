package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

class PhaserScratch {

    public static void main(String[] args) {
        final var phaser = new Phaser(5);
        final var cars = buildCars();
        final var washers = new ArrayList<Washer>();
        for (int i = 0; i < 5; i++) {
            washers.add(new Washer(phaser, i, cars));
        }
        washers.forEach(Thread::start);
    }

    static class Washer extends Thread {

        private final Phaser phaser;

        private final List<Car> cars;

        public Washer(final Phaser phaser, final int i, final List<Car> cars) {
            this.phaser = phaser;
            setName("Washer" + i);
            this.cars = cars;
        }

        @Override
        public void run() {
            for (final Car car : cars) {
                System.out.println(this.getName() + " washing the car " + car.getName());
                System.out.println("washAmount: " + car.wash());
                System.out.println(car.getName() + " washed: " + car.isWashed());
                try {
                    sleep(10000);
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Car {

        private String name;

        AtomicInteger washAmount;

        public Car(final int i) {
            name = "Car" + i;
            washAmount = new AtomicInteger(0);
        }

        public boolean isWashed() {
            return washAmount.get() == 5;
        }

        public int wash() {
            return washAmount.incrementAndGet();
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

    private static List<Car> buildCars() {
        final var cars = new ArrayList<Car>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car(i));
        }
        return cars;
    }
}
