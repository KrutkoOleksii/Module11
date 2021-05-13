package threads;

public class ThreadD implements Runnable{
    private final MyCounter myCounter;

    ThreadD (MyCounter myCounter){
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
                if (!myCounter.fizz()&&!myCounter.buzz()) {
                    myCounter.number();
                    myCounter.add();
                }
                Thread.sleep(1000);
                System.out.println(" we are in the D ");
                myCounter.wait();
                myCounter.notifyAll();
            }
        }
    }
}

