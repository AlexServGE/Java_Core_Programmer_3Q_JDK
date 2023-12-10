public class Task implements Runnable{

    private final int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(number + "<- result of task:" + this.getClass().getName());
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                '}';
    }
}
