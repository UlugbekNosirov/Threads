package pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        long begin = System.currentTimeMillis();
        Runnable runnable = () ->
                System.out.println("Hello world from " + Thread.currentThread().getName());

        int i = 0;
        for (i = 0; i < 1000000; i++) {
            service.execute(runnable);
        }
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("i = " + i);
        System.out.println(end - begin);
    }
}
