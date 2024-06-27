import java.util.concurrent.atomic.AtomicInteger;

public class Clock extends Thread implements Runnable {
    @Override
    public void run() {

        AtomicInteger timer = new AtomicInteger();
        AtomicInteger count = new AtomicInteger();

        Thread clock = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(timer + " seconds past");
                    count.getAndIncrement();
                    Thread.sleep(1000);
                    timer.getAndIncrement();

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        clock.start();
        Thread fiveSecPast = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("Five seconds past");

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        fiveSecPast.start();
    }


}
