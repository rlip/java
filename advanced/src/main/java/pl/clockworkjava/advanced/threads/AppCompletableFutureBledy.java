package pl.clockworkjava.advanced.threads;

import java.util.concurrent.*;

public class AppCompletableFutureBledy {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        final boolean error = true;


        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executorService // tego executor nie trzeba
        );

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(error){
                throw new IllegalArgumentException("Wrong Argument");
            }
            return 42;
        }, executorService).exceptionally(exception -> {
            System.out.println("ERROR!! " + exception.getMessage());
            return 2;
        }).thenApply(r -> {
            System.out.println("*2 " + Thread.currentThread().getName());
            return r*2;
        }).thenApply(r -> {
            System.out.println("+1 " + Thread.currentThread().getName());
            return r+1;
        }).thenAccept(r -> {  //new Consumer<Integer>()
            System.out.println("out " + Thread.currentThread().getName());
            System.out.println(r);

        }); // tego executor nie trzeba -to żeby zmienić wątek wypisujący


        executorService.shutdown();

    }

}
