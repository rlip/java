package pl.clockworkjava.advanced.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppExecutor {
    public static void main(String[] args) {
        System.out.println("Główny wątek: " +  Thread.currentThread().getName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable countDown = () -> {
            try {
                System.out.println("Wykonywany wątek(countdown): " + Thread.currentThread().getName());
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
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
        executorService.submit(countDown);
        executorService.submit(blastOff);

        executorService.shutdown();
//        executorService.shutdownNow();  --- to robi exceptiony bo nie czeka
    }

}
