package pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCacheableThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Runnable runnable = () -> {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread name:%s, Thread count:%s%n", Thread.currentThread().getName(), Thread.activeCount());
        };

        for (int i = 0; i < 1e6; i++) {
            service.execute(runnable);
        }
    }
}