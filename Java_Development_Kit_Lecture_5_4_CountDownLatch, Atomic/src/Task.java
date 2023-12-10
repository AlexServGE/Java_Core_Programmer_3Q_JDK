import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{

    private final AtomicInteger number;
    private CountDownLatch cdl;

    public Task(AtomicInteger number,CountDownLatch cdl) {
        this.number = number;
        this.cdl = cdl;
    }

    public void inc(){
        number.getAndIncrement();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            inc();
        }
        cdl.countDown();

    }

    public AtomicInteger getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                '}';
    }
}
