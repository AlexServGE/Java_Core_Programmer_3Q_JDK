import java.util.ArrayList;
import java.util.List;

public class SynchronizedList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
                list.add(i);
        }
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (list) {
                    list.add(i);
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (list) {
                System.out.println(list);
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}