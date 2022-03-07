import java.util.List;

public class ThreadSynchronization extends Thread{

    private List<Character> names;
    private String message;

    ThreadSynchronization(List<Character> names,String message){
        this.names = names;
        this.message= message;
    }
    @Override
    public void run() {
        //synchronizing shared resource(which is the list(names))
        //synchronizing non-shared resource (which is diff for both the thread, does not make any diff)
        synchronized(this.names) {
            for (int i = 0; i < message.length(); i++) {
                try {
                    System.out.println("Names acquired by Thread: "+Thread.currentThread().getName());
                    names.add(message.charAt(i));
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(names);
        }
    }
}
