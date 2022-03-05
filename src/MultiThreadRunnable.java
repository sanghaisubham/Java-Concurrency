public class MultiThreadRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("Starting Thread : "+Thread.currentThread().getName());
        for(int i=0;i<10;i++)
            System.out.println("Thread using Runnable");
        System.out.println("Completed Thread : "+Thread.currentThread().getName());
    }
}
