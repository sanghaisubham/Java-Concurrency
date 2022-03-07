public class MultiThreadExtend extends Thread{

    private boolean shouldExit = false;
    public MultiThreadExtend(){
        setName("EXTENDS");
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    @Override
    public void run(){
        System.out.println("Starting Thread : "+Thread.currentThread().getName());
        try{
            for(int i=0;i<100;i++) {
                if (shouldExit)
                    break;
                //System.out.println("Thread using extends");
                Thread.sleep(200);
            }
            System.out.println("Completed Thread : "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
