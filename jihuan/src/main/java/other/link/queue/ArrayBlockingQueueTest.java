package other.link.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws Exception{
        BlockingQueue producer = new ArrayBlockingQueue(3);
        producer.put(1);
        producer.put(2);
        producer.put(3);
        System.out.println(producer.toArray());
        System.out.println(producer.poll());
        System.out.println(producer.poll());
        System.out.println(producer.toArray());
        producer.put(4);

        System.out.println(producer.toArray());
        System.out.println(producer.poll());
        producer.put(5);
        System.out.println(producer.poll());
        System.out.println(producer.poll());

    }
}
