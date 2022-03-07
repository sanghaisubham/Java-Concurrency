import java.util.ArrayList;
import java.util.List;

public class ThreadSynchronizationMain {
    public static void main(String[] args) throws InterruptedException {
        List<Character> list= new ArrayList<>();
        ThreadSynchronization th1 = new ThreadSynchronization(list,"HELLO");
        th1.start();

        ThreadSynchronization th2 = new ThreadSynchronization(list,"WORLD");
        th2.start();

        th1.join();
        th2.join();


        ThreadSyncLock tl1 = new ThreadSyncLock(list,"HELLO");
        tl1.start();
        ThreadSyncLock tl2 = new ThreadSyncLock(list,"WORLD");
        tl2.start();

        tl1.join();
        tl2.join();
    }
}
