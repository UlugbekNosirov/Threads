public class Test2 {
    public static void main(String[] args) {
        MyThread2 myRunnable = new MyThread2();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5e1; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}