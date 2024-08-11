public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int i = 0; i < 1_000_000; i++) {
            Main2.counterInc();
        }
        System.out.println(Thread.currentThread().getName() + " finish");
    }
}
