import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class FizzBuzz implements Runnable {
    private Integer n;

    FizzBuzz(Integer n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("");

        for (int i = 0; i < n; i++) {

                if ((i + 1) % 5 == 0 && (i + 1) % 3 == 0) {
                    System.out.println("fizzbuzz");
                } else if ((i + 1) % 5 == 0) {
                    System.out.println("buzz");
                } else if ((i + 1) % 3 == 0) {
                    System.out.println("fizz");
                } else {
                    System.out.println(i + 1);
                }

        }
    }


}
