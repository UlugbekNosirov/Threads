package pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        Runnable runnable1 = () -> System.out.printf("Weak me up, at 6 a.m if it is possible:%s%n", Thread.activeCount());
        Runnable runnable2 = () -> System.out.printf("please:%s%n", Thread.activeCount());
        Runnable runnable3 = () -> System.out.printf("lar:%s%n", Thread.activeCount());

        service.scheduleAtFixedRate(runnable1, 1, 5, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(runnable2, 2, 4, TimeUnit.SECONDS);
        service.schedule(runnable3, 1, TimeUnit.SECONDS);

    }
}
