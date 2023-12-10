import java.util.concurrent.CountDownLatch;

public class Task implements Runnable{

    private int number;
    private CountDownLatch cdl;

    public Task(int number,CountDownLatch cdl) {
        this.number = number;
        this.cdl = cdl;
    }

    public void inc(){
        synchronized (this){
            number++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            inc();
        }
        cdl.countDown();

    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                '}';
    }
}
