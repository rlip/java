package threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class AppCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Główny wątek: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executorService // tego executor nie trzeba
        );

        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 43;
        }, executorService); // tego executor nie trzeba -to żeby zmienić wątek wypisujący

        System.out.println(result.get());

        Callable<Integer> answerToEverything1 = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };
        Callable<Integer> answerToEverything2 = () -> {
            TimeUnit.SECONDS.sleep(13);
            return 43;
        };
        Callable<Integer> answerToEverything3 = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 44;
        };

        List<Callable<Integer>> callableList = Arrays.asList(answerToEverything1, answerToEverything2, answerToEverything3);

        List<Future<Integer>> futures = executorService.invokeAll(callableList); // czeka na wszystkie wyniki i je zwraca
        Integer integer = executorService.invokeAny(callableList); // zwraca 1 wynik uzyskany wynik

        for(Future<Integer> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();

    }

}
