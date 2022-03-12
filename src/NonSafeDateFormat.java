import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class NonSafeDateFormat {
    // Single global object of SimpleDateFormat used across threads but SimpleDateFormat is not ThreadSafe
    // Thread safe: 2 or more threads try to access the object can have data integrity issues
    private static SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String []args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String birthDate = new NonSafeDateFormat().birthDate(100);
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
        Date birthDate = Date.from(Instant.EPOCH);

        //Each Thread creates its own DateFormat objects
        //SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        return df.format(birthDate);
    }
}
