public class Solution02 {
    public static void main(String[] args) throws InterruptedException {
        runSync();
    }

    static void runSync() throws InterruptedException {
        SyncCounter counter = new SyncCounter();
        Runnable task = () -> {
            for (int i = 0; i < 50_000; i++) {
                counter.increment();
                try {
                    Thread.sleep(Math.round(Math.random()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("counter.getCount() = " + counter.getCount());
    }
}

class SyncCounter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}