package pl.strefakursow.observer;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class Mainclass {
    public static void run() {
        //Create Publisher
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Register Subscriber
        MySubscriber<String> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);

        //Publish items
        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
        publisher.close();
    }
}
