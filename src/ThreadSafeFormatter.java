import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){

        // Calls once for each thread
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get(){
            return super.get();
        }
    };

    public static void main(String []args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String birthDate = new NonSafeDateFormat().birthDate(100);
                //Each thread will get its own local copy
                System.out.println("BirthDate from Thread : "+Thread.currentThread().getName()+" is: "+birthDate);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String birthDate = new NonSafeDateFormat().birthDate(100);
                System.out.println("BirthDate from Thread : "+Thread.currentThread().getName()+" is: "+birthDate);
            }
        }).start();
    }

    public String birthDate(int userId){
        Date birthDate =  Date.from(Instant.EPOCH);
        final SimpleDateFormat df =  ThreadSafeFormatter.dateFormatThreadLocal.get();
        return df.format(birthDate);
    }
}
