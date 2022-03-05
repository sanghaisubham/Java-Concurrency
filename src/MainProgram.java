public class MainProgram {
    public static void main(String[] args) {
        ThreadName.printThreadName();

        long sum = Addition.calculateSum(10);
        long sum1 = Addition.calculateSumMultiThread(10);
        System.out.println("The sum is :"+sum);

        for (int i=0;i<10;i++){
            System.out.println("Main Thread is free");
        }
        createThread();;

    }

    static  void createThread(){
        MultiThreadExtend extend = new MultiThreadExtend();
        MultiThreadRunnable runnable = new MultiThreadRunnable();

        Thread t2 = new Thread(runnable);
        t2.setName("RUNNABLE");

        extend.start();
        t2.start();
    }
}
