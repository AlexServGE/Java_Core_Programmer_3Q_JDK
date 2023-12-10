public class TicTak implements Runnable{

    private final String number;
    private final Object monitor;


    public TicTak(String number) {
        this.number = number;
        this.monitor = TicTak.class; //в чем разница между TicTak.class и  this?
    }

    @Override
    public void run() {
        while(true){ //
            synchronized (monitor) {
                System.out.print(number);
                try {
                    Thread.sleep(300);
//                    monitor.notify();
                    monitor.wait(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
