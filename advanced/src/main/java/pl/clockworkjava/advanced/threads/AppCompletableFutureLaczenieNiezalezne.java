package pl.clockworkjava.advanced.threads;

import java.util.concurrent.*;

public class AppCompletableFutureLaczenieNiezalezne {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        CompletableFuture<Long> cfuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 32L;
        });


        CompletableFuture<Long> cfuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2L;
        });


        CompletableFuture<Long> longCompletableFuture = cfuture1.thenCombine(cfuture2, (result1, result2) -> {
            return result1 * result2;
        });

        Long aLong = longCompletableFuture.get();

        System.out.println(aLong);

        executorService.shutdown();

    }


}
