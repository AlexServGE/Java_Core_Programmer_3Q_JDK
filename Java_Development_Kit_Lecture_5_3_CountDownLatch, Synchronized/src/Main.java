
import java.util.concurrent.CountDownLatch;


public class Main {
    public static void main(String[] args) throws InterruptedException { //поток main
        CountDownLatch cdl = new CountDownLatch(3);
        Task task = new Task(0,cdl);
        for (int i = 0; i < 3; i++) {
            Thread thd = new Thread(task);
            thd.start();
        }
        cdl.await();
        System.out.println(task.getNumber());
    }
}