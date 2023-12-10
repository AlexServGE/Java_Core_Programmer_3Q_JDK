import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger counter = new AtomicInteger(0);
    static CountDownLatch ctl = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new ThreadTask()).start();
        new Thread(new ThreadTask()).start();
        ctl.await();
        System.out.println(Thread.currentThread() + "Counter: " + counter);
    }

    public static class ThreadTask implements Runnable{
        ThreadLocal<Integer> threadCounter = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter.getAndIncrement();
                if (threadCounter.get() != null){
                    threadCounter.set(threadCounter.get()+1);
                } else {
                    threadCounter.set(1);
                }
            }

            System.out.println(Thread.currentThread() + "threadLocalCounter: " + threadCounter.get());
            ctl.countDown();
        }
    }
}