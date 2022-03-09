package pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCustomThreadPool {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                10, 1000, 50,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());


    }
}
