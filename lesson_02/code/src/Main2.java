import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        System.out.println("Main2 start");
        Thread[] threads = {
                new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task()),

        };
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Main2 finish. Counter = " + counter.toString());
    }

    public static void counterInc() {
        counter.getAndIncrement();
    }


}