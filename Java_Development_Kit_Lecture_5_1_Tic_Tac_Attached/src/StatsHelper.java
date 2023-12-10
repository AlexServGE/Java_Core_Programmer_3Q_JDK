import java.util.Scanner;

public class StatsHelper {

    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(()->{
            Scanner in = new Scanner(System.in);
            while (true){
                String line = in.nextLine();
                System.out.println(line);
                cnt++;
            }
        });
        readThread.start();

        while(true){
            System.out.println(cnt+" messages inputted by user");
            Thread.sleep(1000);
        }
    }
}
