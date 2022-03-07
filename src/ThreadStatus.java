public class ThreadStatus{
    public static void main(String args[]) throws InterruptedException {

        MultiThreadRunnable multiThreadRunnable= new MultiThreadRunnable();
        Thread th1 = new Thread(multiThreadRunnable);
        th1.setName("HIGH Priority Thread");
        th1.setPriority(Thread.MAX_PRIORITY);
        th1.start();
        //main Thread waits for the th1 thread to die(complete)
        //The thread from which we are calling Thread join(here main thread) will wait for the thread (th1) to be completed
        //Here it will wait for max 3 milliseconds for th1 to complete
        long startTime = System.currentTimeMillis();
        th1.join(3);
        long timeTaken = System.currentTimeMillis()-startTime;
        System.out.println("Join completed within: " +timeTaken+"ms");
        System.exit(0);
        //Checking Thread Active or Not
        while (th1.isAlive()){
            System.out.println("Thread is Active");
        }
        System.out.println("Thread is Completed");
    }
}
