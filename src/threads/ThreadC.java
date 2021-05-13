package threads;

public class ThreadC implements Runnable{
    private final MyCounter myCounter;

    ThreadC (MyCounter myCounter){
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
                if (myCounter.fizzbuzz()) {
                    System.out.println("fizzbuzz");
                    myCounter.add();
                }
                Thread.sleep(1000);
                System.out.println(" we are in the C ");
                myCounter.wait();
                myCounter.notifyAll();
            }
        }
    }
}

