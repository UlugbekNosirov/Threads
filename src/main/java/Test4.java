public class Test4 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            int a = 12;
            for (int i = 0; i <= a; i++) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
            }
        };


        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
    }
}

