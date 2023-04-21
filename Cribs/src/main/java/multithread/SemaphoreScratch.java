package multithread;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class SemaphoreScratch {

    public static void main(String[] args) {
        final var semaphore = new Semaphore(1);
        final var persons = new ArrayList<Person>();
        for (int i = 0; i < 20; i++) {
            persons.add(new Person(semaphore, i));
        }
        persons.forEach(Thread::start);
        System.out.println("All done");
    }
}

class Person extends Thread {

    private final Semaphore semaphore;

    public Person(final Semaphore semaphore, final int number) {
        this.semaphore = semaphore;
        setName("Person " + number);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.getName() + " waiting for table");
            semaphore.acquire();
            System.out.println(this.getName() + " eats at the table");
            sleep(3000);
            System.out.println(this.getName() + " release the table");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
