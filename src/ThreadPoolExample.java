import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String []args){
        ThreadPoolExample threadPoolExample = new ThreadPoolExample();
        threadPoolExample.startThreadPoolExample();
    }

    private void startThreadPoolExample(){
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        WorkerTask workerTask1 = new WorkerTask("Task-1");
        WorkerTask workerTask2 = new WorkerTask("Task-2");
        WorkerTask workerTask3 = new WorkerTask("Task-3");
        WorkerTask workerTask4 = new WorkerTask("Task-4");
        WorkerTask workerTask5 = new WorkerTask("Task-5");
        WorkerTask workerTask6 = new WorkerTask("Task-6");
        WorkerTask workerTask7 = new WorkerTask("Task-7");

        executorService.submit(workerTask1);
        executorService.submit(workerTask2);
        executorService.submit(workerTask3);
        executorService.submit(workerTask4);
        executorService.submit(workerTask5);
        executorService.submit(workerTask6);
        executorService.submit(workerTask7);

        executorService.shutdown();
    }
}
