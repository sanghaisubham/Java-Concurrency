public class Addition {
    static long calculateSum(int number){

        long sum=0;

    for(int i=0;i<=number;i++){
        //Running on main thread
        System.out.println("Sum is running on thread "+Thread.currentThread().getName());
        sum+=i;
    }
    return sum;

    }

    static long calculateSumMultiThread(int number){
        long sum = 0;
        new Thread(()-> {
            long sum1=0;
            for (int i = 0; i <= number; i++) {
                //Running on some other thread(Not on main thread)
                System.out.println("MultiThreaded Sum is running on thread "+Thread.currentThread().getName());
                sum1 += i;
            }
        }).start();
        return sum;
    }
}
