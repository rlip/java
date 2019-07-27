package pl.clockworkjava.advanced.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppExecutorSchedule {
    public static void main(String[] args) {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            try {
                for (int i = 0; i < 10 ; i++){
                    System.out.println("Robotnik 1 - Aktualny wątek: " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(8);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker2 = () -> {
            try {
                for (int i = 0; i < 10 ; i++) {
                    System.out.println("Robotnik 2 - Aktualny wątek: " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(13);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker3 = () -> {
            try {
                for (int i = 0; i < 10 ; i++) {
                    System.out.println("Robotnik 3 - Aktualny wątek: " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(18);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.submit(worker1);
        executorService.submit(worker2);
        executorService.submit(worker3);

    //    executorService.schedule(worker1, 5, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(worker3, 0, 6, TimeUnit.SECONDS);

//        executorService.shutdown();

    }

}
