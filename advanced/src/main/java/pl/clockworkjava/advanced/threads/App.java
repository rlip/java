package pl.clockworkjava.advanced.threads;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {

        System.out.println("Główny wątek: " + Thread.currentThread().getName());
        Thread thread = new MyThread("wątek1");
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                IntStream.rangeClosed(1, 200).forEach(i -> {
//                    System.out.println(i + "| Wykonywany wątek: " + Thread.currentThread().getName());
//                });
//            }
//        };
        Runnable countDown = () -> {
            try {
                System.out.println("Wykonywany wątek(countdown): " + Thread.currentThread().getName());
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
//                    Thread.sleep(1000);  Można tez tak
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable blastOff = () -> {
            System.out.println("Wykonywany wątek(countdown): " + Thread.currentThread().getName());
            System.out.println("BlastOff");
        };

        Thread countDownThread = new Thread(countDown, "countdown");
        Thread blastOffThread = new Thread(blastOff, "blastOff");

        countDownThread.start();
        try {
            countDownThread.join(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Główny wątek: " +  Thread.currentThread().getName());
        blastOffThread.start();
    }

}
