import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution03 {
    public static void main(String[] args) {
        runAtomic();
    }

    static void runMap() {
        Map<String, Integer> map = new HashMap<>();
    }

    static void runAtomic() {
        AtomicInteger atomicCount = new AtomicInteger(0); // 객체
        NonAtomic nonAtomicCount = new NonAtomic();
        int limit = 50_000;
        Runnable task = () -> {
            for (int i = 0; i < limit; i++) {
                atomicCount.incrementAndGet();
                nonAtomicCount.increment();
            }
        };
        Thread t = new Thread(task);
        Thread t2 = new Thread(task);
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("atomic : " + atomicCount.get());
        System.out.println("non-atomic : " + nonAtomicCount.getCount());
    }

}

class NonAtomic {
    private int count;

    void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}
