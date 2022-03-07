public class NonDaemonThread {

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
       th.start();

        //main Thread will wait for max 10 sec for the above thread to complete and then execute
        // If the above Thread does not complete within 10 sec, it will start
       th.join(10000);
        //Main Thread completed but program has not exited as the th thread is still running
        System.out.println("Expecting Program Shutdown now");

        System.exit(0); //Closes all the running threads
    }
}
