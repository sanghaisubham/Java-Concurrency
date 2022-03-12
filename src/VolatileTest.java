// Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
//Volatile variables have the visibility features of synchronized but not the atomicity features
public class VolatileTest {
    private volatile static int MY_INT = 0;
    private  boolean flag = false;

    public static void main(String[] args)
    {
        VolatileTest volatileTest = new VolatileTest();
        new ChangeListener().start();
        new ChangeMaker().start();

        Thread flagChanger = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The value of flag is : "+volatileTest.flag+" for thread Name "+Thread.currentThread().getName()+" at time "+System.currentTimeMillis());
                volatileTest.flag=true;
            }
        });

        Thread flagListener = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The value of flag is : "+volatileTest.flag+" for thread Name "+Thread.currentThread().getName()+" at time "+System.currentTimeMillis());
            }
        });
        flagChanger.setName("Flag Changer");
        flagListener.setName("Flag Listener");

        flagChanger.start();
        flagListener.start();

    }

    static class ChangeListener extends Thread {
        ChangeListener(){
            setName("ChangeListener");
        }

    }

    static class ChangeMaker extends Thread {

        ChangeMaker(){
            setName("ChangeMaker");
        }
        @Override public void run()
        {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("Inside Thread "+Thread.currentThread().getName());
                System.out.println("Incrementing MY_INT to :"+ (local_value + 1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
