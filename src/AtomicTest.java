import java.util.concurrent.atomic.AtomicInteger;

// Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
//Volatile variables have the visibility features of synchronized but not the atomicity features
public class AtomicTest {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static int counterNormal = 0;

    public static void main(String[] args) {
        Thread countChangerAtomic1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter.get()<10) {
                    System.out.println("The value of counter is : " + (counter.addAndGet(1)) + " for thread Name " + Thread.currentThread().getName() + " at time " + System.currentTimeMillis());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread countChangerAtomic2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter.get()<10) {
                    System.out.println("The value of counter is : " + counter.addAndGet(1) + " for thread Name " + Thread.currentThread().getName() + " at time " + System.currentTimeMillis());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        countChangerAtomic1.setName("Count Changer Atomic 1");
        countChangerAtomic2.setName("Count Changer Atomic 2");


        Thread countChangerNormal1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counterNormal<10) {
                    counterNormal++;
                    System.out.println("++ The value of counter is : " + (counterNormal) + " for thread Name " + Thread.currentThread().getName() + " at time " + System.currentTimeMillis());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread countChangerNormal2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counterNormal<10) {
                    counterNormal++;
                    System.out.println("++ The value of counter is : " + counterNormal + " for thread Name " + Thread.currentThread().getName() + " at time " + System.currentTimeMillis());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        countChangerNormal1.setName("Count Changer Normal 1");
        countChangerNormal2.setName("Count Changer Normal 2");

        //Same Value is never repeated
        //countChangerAtomic1.start();
        //countChangerAtomic2.start();

        //Same Value can be  repeated
        countChangerNormal1.start();
        countChangerNormal2.start();

    }

}