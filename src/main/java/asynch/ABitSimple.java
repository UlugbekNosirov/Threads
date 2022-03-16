package asynch;

import org.w3c.dom.ls.LSResourceResolver;

import java.util.Random;
import java.util.concurrent.*;

public class ABitSimple {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /* check for sender*/
        /* check for receiver*/
        /* check for transfer*/
        /* success message*/
        long begin = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(10);
        /*Callable<Boolean> uzCardCheck = () -> {
            Thread.sleep(3000);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return true;
        };
        Future<Boolean> uzcard = service.submit(uzCardCheck);

        if (uzcard.get()) {

            Callable<Boolean> humoCheck = () -> {
                Thread.sleep(4000);
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                return true;
            };
            Future<Boolean> humo = service.submit(humoCheck);
            if (humo.get()) {
                Callable<Boolean> transfer = () -> {
                    Thread.sleep(1000);
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    return true;
                };
                Future<Boolean> submit = service.submit(transfer);
                if (submit.get()){
                    System.out.println("Success");
                }
            }
        }*/
        Callable<Boolean> uzCardCheck = () -> {
            Thread.sleep(3000);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return true;
        };

        Callable<Boolean> humoCheck = () -> {
            Thread.sleep(4000);
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return true;
        };
        Future<Boolean> uzcard = service.submit(uzCardCheck);
        Future<Boolean> humo = service.submit(humoCheck);
        if (uzcard.get() && humo.get()){
            Callable<Boolean> transfer = () -> {
                Thread.sleep(1000);
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                return true;
            };
            Future<Boolean> submit = service.submit(transfer);
            if (submit.get()) {
                System.out.println("Success");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("(end-begin) = " + (end - begin));

    }
}
