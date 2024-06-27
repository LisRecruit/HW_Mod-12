import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class FizzBuzz {
    private final int n;
    private int current = 1;
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                queue.add("fizz");
                //System.out.println("fizz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        }
    }

    public synchronized void buzz() {
        while (current <= n) {
            if (current % 5 == 0 && current % 3 != 0) {
                queue.add("buzz");
//                System.out.println("buzz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                queue.add("fizzbuzz");
//                System.out.println("fizzbuzz");
                current++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number() {
        while (current <= n) {
            synchronized (this) {
                if (current % 3 != 0 && current % 5 != 0) {
                    queue.add(String.valueOf(current));
                    current++;
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        System.out.println(queue.toString());

    }


}

