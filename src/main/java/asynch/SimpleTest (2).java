package asynch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.*;

public class SimpleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(new Task());
        List<Future<Integer>> futures = new ArrayList<>();
//        futures.add(service.submit(new Task()));
//        futures.add(service.submit(new Task()));

        for (int i = 0; i < 1000; i++) {
            futures.add(service.submit(new Task()));
        }

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }
//        service.shutdown();
//        service.submit(new Task());// throws RejectedExecutionException
//        if (!service.isShutdown()) {
//            boolean b = service.awaitTermination(1, TimeUnit.SECONDS);
//            service.shutdownNow();
//        }
    }


    public static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName());
            return new Random().nextInt(10, 100);
        }

    }


}
