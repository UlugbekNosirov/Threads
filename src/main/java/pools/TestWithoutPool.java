package pools;

public class TestWithoutPool {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Runnable runnable = () ->
                System.out.println("Hello world from " + Thread.currentThread().getName());
        int i;
        for (i = 0; i < 1000000; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(10000);
        long end = System.currentTimeMillis();
        System.out.println("i = " + i);
        System.out.println(end - begin);
    }
}
