package pl.clockworkjava.advanced.threads;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            System.out.println(i + "| Wykonywany wątek: " + Thread.currentThread().getName());
        });
    }


    public MyThread(String name) {
        this.setName(name);
    }
}
