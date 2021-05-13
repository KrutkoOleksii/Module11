package threads;

public class ThreadA implements Runnable{
    private final MyCounter myCounter;

    ThreadA (MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" started");
        try {
            add();
        } catch (InterruptedException e) {
            new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" finished");
    }

    private void add() throws InterruptedException {
        synchronized (myCounter) {
            while (myCounter.getCount() < myCounter.getTime()){
                if (myCounter.fizz()) {
                    System.out.println("fizz");
                    myCounter.add();
                }
                Thread.sleep(1000);
                System.out.println(" we are in the A ");
                myCounter.wait();
                myCounter.notifyAll();
            }
        }
    }
}
