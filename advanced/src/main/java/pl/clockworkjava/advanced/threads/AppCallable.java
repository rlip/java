package pl.clockworkjava.advanced.threads;

import java.util.concurrent.*;

public class AppCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Główny wątek: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//
//        Callable<Integer> answerToEverything = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return null;
//            }
//        };
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        Future<Integer> result = executorService.submit(answerToEverything);

        Integer integer = null;
        try {
            integer = result.get(4, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(integer);

        executorService.submit(answerToEverything);



    }

}
