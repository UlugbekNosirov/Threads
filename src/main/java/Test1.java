public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("Aql Tosh");
        thread1.start();
        System.out.println(Thread.currentThread().getName() + " thread is running");
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
    }
}


class MyThread extends Thread {

    MyThread(String name) {
        super.setName(name);
    }

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



