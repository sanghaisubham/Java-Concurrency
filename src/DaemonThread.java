public class DaemonThread {

    public static void main(String []args) throws InterruptedException {
        Thread th= new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.setDaemon(true);
        th.start();
        //Main Thread completed and program has exited as the th running thread is daemon thread

        //JVM exists, when the only thread running are the daemon threads

        System.out.println("The thread: "+Thread.currentThread().getName()+" is Daemon: "+Thread.currentThread().isDaemon());
        System.out.println("Expecting Program Shutdown now");
    }
}
