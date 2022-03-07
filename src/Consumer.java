import java.util.List;

public class Consumer extends Thread{

    private List<String> message;
    private Producer producer;

    public Consumer(List<String>message,Producer producer){
        this.message = message;
        this.producer=producer;
    }

    @Override
    public void run(){
        try{
            while (true){
                System.out.println("Current Running Thread: "+Thread.currentThread().getName());
                String data = producer.consume();
                System.out.println("Consumed by: "+Thread.currentThread().getName()+" Data: "+data);
            }
        }catch (Exception exp){

        }

    }


}
