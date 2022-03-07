public class ThreadPauseResume {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadExtend threadExtend = new MultiThreadExtend();
        threadExtend.start();
        //Thread completion message is not printed as Thread is not closed properly
        //threadExtend.join(3000); // Will wait max for 3 sec

        Thread.sleep(3000); //Will sleep for 3 sec
        while(threadExtend.isAlive()){
            threadExtend.setShouldExit(true);
        }
    System.exit(0);
    }
}
