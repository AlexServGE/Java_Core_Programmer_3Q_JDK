import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) { //поток main
        Queue<Task> taskQueue = new ArrayDeque<>();

        ExecutorService executors = Executors.newFixedThreadPool(2); //по идее должно быть в отдельно классе taskService
        Thread taskService = new Thread(()->{ //поток taskService (отдельно от main)
            while(true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                executors.submit(()->{    //поток ExecutorService (отдельно от main и taskService)
                    Task task = taskQueue.poll();
                    if(task != null) {
                        System.out.println(task);
                        task.run();
                    }
                });
            }
        });
        taskService.start();



        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()) {
            String userInput = in.nextLine();
            int userNumber = Integer.parseInt(userInput);
            Task task = new Task(userNumber);
            taskQueue.add(task);
        }
        executors.shutdown();
    }
}