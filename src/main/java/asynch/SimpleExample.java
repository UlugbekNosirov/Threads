package asynch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(30);

        Runnable runnable = () -> {
            User user = new User();
            try {
                user.printAge();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 200000; i++) {
            service.submit(runnable);
        }

    }


    public static class User {
        private Date birthdate;

        public User() {
            this.birthdate = new Date();
        }

        public void printAge() throws InterruptedException {
            Thread.sleep(3000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormatThreadLocal().get();

            String formattedDate = simpleDateFormat.format(this.birthdate);
            System.out.println("formattedDate = " + formattedDate);
        }

    }

    static public class SimpleDateFormatThreadLocal extends ThreadLocal<SimpleDateFormat> {

        public SimpleDateFormat get() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }


//        SimpleDateFormat format = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd")).get();

    }
}
