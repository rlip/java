package pl.clockworkjava.advanced.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i=0; i< 2000; i++){
            executorService.submit(() -> counter.increase());
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(counter.getCounter());


    }
}



class Counter {
    private int count = 0;

    public int getCounter() {
        return count;
    }

    public void increase(){

        System.out.println("costam ");
        System.out.println("costam 2");
        synchronized (this){
            count++;
        }
        System.out.println("costam 3");
    }
}
// można tez tak
class Counter2 {
    private AtomicInteger count = new AtomicInteger(0);

    private int getCount() {
        return count.get();
    }


    public void increase(){
        count.getAndIncrement();
    }
}