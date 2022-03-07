public class MultiThreadRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("Starting Thread : "+Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000000;i++) {
            //System.out.println("Thread using Runnable with threadName "+Thread.currentThread().getName());
        }
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("Completed Thread : "+Thread.currentThread().getName()+" in : "+timeTaken+"ms");
    }
}
