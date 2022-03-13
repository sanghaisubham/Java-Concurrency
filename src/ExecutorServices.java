import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServices {

    public static void main(String []args){
        int coreCount = Runtime.getRuntime().availableProcessors();

        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(coreCount);
        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
        ScheduledExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(coreCount);

        //task to run after 10 sec delay
        executorServiceScheduled.schedule(new Task(),10, TimeUnit.SECONDS);

        //task to run repeatedly every 10 seconds; with initial wait for 15 seconds
        executorServiceScheduled.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);

        //task to run repeatedly 10 seconds after previous task completes
        executorServiceScheduled.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);

    }
}

    class Task implements Runnable{
    @Override
    public void run(){

    }
}
