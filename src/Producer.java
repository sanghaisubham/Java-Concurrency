import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer extends Thread{
    private static final int MAX_SIZE =3 ;

    private List<String> message = new ArrayList<>();
    private static Lock lock = new ReentrantLock();

//    public  Producer(List<String>message){
//        this.message = message;
//    }
    @Override
    public void run(){

        try{
        while (true){
            System.out.println("Current Running Thread: "+Thread.currentThread().getName());
            produce();
        }
        }catch (Exception exp){

        }

    }

    private synchronized void produce() throws InterruptedException {
            while (message.size() == MAX_SIZE) {
                System.out.println("Queue is FULL. Waiting for Consumer Notification");
                wait();
                System.out.println("Got Notification from Consumer");
            }
            String data = LocalDateTime.now().toString();
            message.add(data);
            System.out.println("Producer produced: " + data);
            notify();
    }

    public synchronized String consume() throws InterruptedException {
            while (message.isEmpty()) {
                System.out.println("Queue is Empty. Waiting for Producer Notification");
                wait();
                System.out.println("Got Notification from Producer");
            }
            //lock.lock();
            String data = message.get(0);
            System.out.println("Data : " + data);
            message.remove(data);
            notify();
            //lock.unlock();
            return data;
    }

}
