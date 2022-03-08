public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread thread1 = new Thread(new MyThread5(count));
        Thread thread2 = new Thread(new MyThread5(count));
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
    }
}


class Count {
    public Integer i = 0;

    public synchronized void inc() {
        this.i++;
    }
}


class MyThread5 implements Runnable {
    private final Count count;

    MyThread5(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.inc();
        }
        System.out.println(Thread.currentThread().getName() + " -> " + count.i);
    }
}