package asynch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        AtomicLong atomicLong = new AtomicLong(1L);
        for (int i = 0; i < 1E2; i++) {
            atomicInteger.compareAndSet(12123, 1123123);
//            System.out.println(atomicInteger.get());
            System.out.println("atomicInteger.getAndIncrement() = " + atomicInteger.getAndIncrement());
        }
    }
}
