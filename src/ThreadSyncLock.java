import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSyncLock extends Thread{

    private List<Character> names;
    private String message;
    //lock has to be shared between threads and so has to be made static
    private static Lock lock = new ReentrantLock();

    ThreadSyncLock(List<Character> names,String message){
        this.names = names;
        this.message= message;
    }
    @Override
    public void run() {
        //using Java locks we can lock and unlock in different methods
        lock.lock();
        System.out.println("Lock acquired by Thread: " + Thread.currentThread().getName());
        try {
            for (int i = 0; i < message.length(); i++) {
                names.add(message.charAt(i));
                Thread.sleep(50);

            }
            System.out.println(names);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Lock unlocked by Thread: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
