
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new TicTak("1"));
        Thread two = new Thread(new TicTak("2"));
        Thread three = new Thread(new TicTak("3"));
//    tic.setDaemon(true);
//    tac.setDaemon(true);
        one.start();
        two.start();
        three.start();
    }
}