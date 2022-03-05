public class ThreadName {

    static void printThreadName(){
        Thread th =  Thread.currentThread();
        System.out.println("Current Thread is "+th.getName());

        //Setting Thread Name
        //th.setName("My Thread");

        System.out.println("Updated Thread is "+th.getName());

        Thread t1 = new Thread();

        System.out.println("New Thread is "+t1.getName());
    }
}
