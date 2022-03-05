public class MultiThreadExtend extends Thread{

    public MultiThreadExtend(){
        setName("EXTENDS");
    }
    @Override
    public void run(){
        System.out.println("Starting Thread : "+Thread.currentThread().getName());
        for(int i=0;i<10;i++) {
            System.out.println("Thread using extends");
//            try {
//                //Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Completed Thread : "+Thread.currentThread().getName());
    }

}
