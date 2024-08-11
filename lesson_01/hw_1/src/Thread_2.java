public class Thread_2 implements Runnable {


    @Override
    public void run() {
        System.out.println("start Thread_2");

        for (int i = 1; i < 30; i++) {
            if (i % 3 == 0) {
                System.out.println(i + " делится на 3");
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finish Thread_2");

    }
}
