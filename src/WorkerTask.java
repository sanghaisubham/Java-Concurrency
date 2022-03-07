public class WorkerTask implements Runnable{

    private long createdTime;
    private String taskName;

    WorkerTask(String taskName){
        this.taskName= taskName;
        this.createdTime = System.currentTimeMillis();
    }
    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();
        long waitedTime = System.currentTimeMillis()-createdTime;
        System.out.println(taskName+ " got CPU after waiting for "+waitedTime+" ms with thread "+currentThread.getName());

        try{
            Thread.sleep(3000);
            System.out.println(taskName+" completed. Releasing thread "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
