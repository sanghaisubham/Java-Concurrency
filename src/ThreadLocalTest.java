// ThreadLocal class is used to create thread local variables which can only be read and written by the same thread.
// Each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable.
// ThreadLocal provides thread restriction which is extension of local variable.

//Thread Local: Create instance which are specific to thread helping in memory efficiency and thread safety
public class ThreadLocalTest {

    public static void main(String[] args) {
        RunnableDemo commonInstance = new RunnableDemo();

        Thread t1 = new Thread(commonInstance);
        Thread t2 = new Thread(commonInstance);
        Thread t3 = new Thread(commonInstance);
        Thread t4 = new Thread(commonInstance);

        t1.setName("Thread Common Obj 1");
        t2.setName("Thread Common Obj 2");
        t3.setName("Thread Common Obj 3");
        t4.setName("Thread Common Obj 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

      //Note: When using separate object, counter variable is also a local copy(separate) for each thread as the object is new altogether
        Thread t5 = new Thread(new RunnableDemo());
        Thread t6 = new Thread(new RunnableDemo());
        Thread t7 = new Thread(new RunnableDemo());
        Thread t8 = new Thread(new RunnableDemo());

        t4.setName("Thread Sep Obj 1");
        t6.setName("Thread Sep Obj 2");
        t7.setName("Thread Sep Obj 3");
        t8.setName("Thread Sep Obj 4");

        t5.start();
        t6.start();
        t7.start();
        t8.start();

        // wait for threads to end
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

class RunnableDemo implements Runnable {
    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();

    public void run() {

        //Normal variable is sharing the same thread
        counter++;

        //Two threads are accessing code having reference to same threadLocal variable then each thread
        // will not see any modification to threadLocal variable done by other thread.
        if(threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get() + 1);
        } else {
            threadLocalCounter.set(0);
        }
        System.out.println("Counter: " + counter+" for thread: "+Thread.currentThread().getName());
        System.out.println("threadLocalCounter: " + threadLocalCounter.get());
    }
}