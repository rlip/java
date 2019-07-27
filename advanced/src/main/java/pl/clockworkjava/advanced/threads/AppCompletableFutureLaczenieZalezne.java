package pl.clockworkjava.advanced.threads;

import java.util.concurrent.*;

public class AppCompletableFutureLaczenieZalezne {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        CompletableFuture<Long> userIdFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getUserId();
        });

        CompletableFuture<Void> future = userIdFuture.thenCompose(userId -> CompletableFuture.supplyAsync( () -> getDiscount(userId))).thenAccept(
                discount -> System.out.println("Discount " + discount)
        );
        future.get();

        executorService.shutdown();

    }

    public static Long getUserId() {
        return 324L;
    }

    public static Double getDiscount(Long userId){
        return 0.15;
    }

}
