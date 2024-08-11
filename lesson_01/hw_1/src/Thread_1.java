public class Thread_1 extends Thread{

    private int start;
    private int stop;

    public Thread_1(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {

        /*
        можно было сделать бесконечный цикл
        int i = 1;
        while(true){
        i++;
        if (i%2 == 0){
                System.out.println(i + " делится на 2");
            }
        }

        или избежать цикла:
        int i = 2;
        while(true){
                System.out.println(i + " делится на 2");
                i+=2;
            }
        }

         */

        System.out.println("Start Thread_1");

        for (int i = start; i < stop; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " делится на 2");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finish Thread_1");
    }
}
