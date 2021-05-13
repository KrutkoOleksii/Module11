package threads;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Прошло 5 секунд");
    }
}
