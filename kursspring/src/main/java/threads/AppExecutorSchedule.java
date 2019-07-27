package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppExecutorSchedule {
    public static void main(String[] args) {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Ładuję butlę z tlenem");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Koniec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Zapas pożywienia");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Ładuje paliwo");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

    //   executorService.schedule(worker1, 5, TimeUnit.SECONDS);
       executorService.scheduleAtFixedRate(worker3, 0, 6, TimeUnit.SECONDS);

//        executorService.shutdown();

    }

}
