
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class AtomicArray {
    public static void main(String[] args) {
        Queue<Integer> list = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 2; i++) {
            list.add(i);
        }
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        Runnable r2 = () -> {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}