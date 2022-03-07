public class ThreadPriority{
    public static void main(String args[]){
        Thread th = new Thread();
       MultiThreadRunnable multiThreadRunnable= new MultiThreadRunnable();
       Thread th1 = new Thread(multiThreadRunnable);
       th1.setName("HIGH Priority Thread");
       th1.setPriority(Thread.MAX_PRIORITY);
       th1.start();

        Thread th2 = new Thread(multiThreadRunnable);
        th2.setName("LOW Priority Thread");
        th2.setPriority(Thread.MIN_PRIORITY);
        th2.start();

        Thread th3 = new Thread(multiThreadRunnable);
        th3.setName("NORMAL Priority Thread");
        th3.setPriority(Thread.NORM_PRIORITY);
        th3.start();

    }
}
