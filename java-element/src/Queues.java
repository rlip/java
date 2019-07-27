import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//ArrayBlockingQueue jest dobre do multiwątkowości, bo 1 wątek może czekać na dane w kolejce

public class Queues {
    public static void main(String[] args) {
        // (head) <- 000000000000000000000 <- (tail)  FIFO

        Queue<Integer> q1 = new ArrayBlockingQueue<>(3);

        q1.add(10);
        q1.add(20);
        q1.add(30);
        try {
            q1.add(40);
        } catch (IllegalStateException e) {
            System.out.println("Tried to add too many items to the queue");
        }

        System.out.println("Head of queue is: " + q1.element()); //throws noSuchElement exception

        for (Integer value : q1) {
            System.out.println("Queue value: " + value);
        }

        Integer value;
        value = q1.remove();
        System.out.println("Removed grom queue: " + value);
        value = q1.remove();
        System.out.println("Removed grom queue: " + value);
        value = q1.remove();
        System.out.println("Removed grom queue: " + value);
        try {
            value = q1.remove();
        } catch (NoSuchElementException e) {
            System.out.println("Tied to remove too many items from queue");
        }

        ///////////////////////////////////////////////////

        Queue<Integer> q2 = new ArrayBlockingQueue<>(2);
        q2.add(10);
        q2.add(20);

        for (Integer value2 : q2) {
            System.out.println("Queue 2 value: " + value2);
        }

        System.out.println("Queue 2 poll: " + q2.poll());
        System.out.println("Queue 2 poll: " + q2.poll());
        System.out.println("Queue 2 poll: " + q2.poll()); //a peak z przodu
    }
}
