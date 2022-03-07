import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerMain {
    public static void main(String[] args){

        List<String> message = new ArrayList<>();
        Producer producer = new Producer();
        Consumer consumer = new Consumer(message,producer);

        producer.setName("Producer-1");
        consumer.setName("Consumer-1");

        producer.start();
        consumer.start();
    }
}
