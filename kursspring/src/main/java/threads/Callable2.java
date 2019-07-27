package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Callable2 {

    public static class Counter implements Callable<String> {
        private int SIZE;
        private int counter = 0;
        private String name;
        public Counter(int size, String name) {
            this.SIZE = size;
            this.name = name;
        }
        @Override
        public String call() throws InterruptedException {
            while(this.counter < SIZE) {
                this.counter++;
            }
            TimeUnit.SECONDS.sleep(1);
            return "Done " + this.name;
        }
    }

    public static void main(String args[]) throws Exception {
        int size = 1000000;
        ExecutorService pool = Executors.newFixedThreadPool(2);
        List<Future<String>> listOfFutures = new ArrayList<Future<String>>();

        for(int i=0; i<10; i++) {
            Callable<String> callableCounter = new Counter(size, "counter" + i);
            Future<String> futureCounterResult = pool.submit(callableCounter);
            listOfFutures.add(futureCounterResult);
        }
        for (Future<String> future : listOfFutures) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }
}
