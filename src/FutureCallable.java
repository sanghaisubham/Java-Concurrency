import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class FutureCallable {

    public static void main(String []args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ArrayList<Future> futures = new ArrayList<>();
        for(int i=0;i<10;i++){
            //Future is placeholder for a value that will arrive some time in future
            Future<Integer> future = executorService.submit(new WorkTask());
            futures.add(future);
        }

        for (int i=0;i<10;i++){
            System.out.println("Is the future cancelled for i: "+i+" :"+futures.get(i).isCancelled());
            System.out.println("Is the future completed for i: "+i+" :"+futures.get(i).isDone());

            //Main thread is blocked until the task is completed and future is ready to return a value
            System.out.println("The value for future : "+i+" is: "+futures.get(i).get(5, TimeUnit.SECONDS));
            System.out.println("Is the future cancelled for i: "+i+" :"+futures.get(i).isCancelled());
            System.out.println("is the future completed for i: "+i+" :"+futures.get(i).isDone());
            System.out.println("===========================================================");
        }
    }
}

//Callable is used when we want to return a value from our task
class WorkTask implements Callable<Integer>{
    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(3000);
        return new Random().nextInt();
    }
}
