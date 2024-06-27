public class Main {
    public static void main(String[] args) {
//       Thread clock = new Thread(new Clock());
//        clock.start();
        Thread fizzBuzz = new Thread(new FizzBuzz(15));
        fizzBuzz.start();

    }
}
