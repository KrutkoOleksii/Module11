package threads;

public class ThreadC implements Runnable{
    private final MyCounter myCounter;

    ThreadC (MyCounter myCounter){
        this.myCounter = myCounter;
    }

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            new RuntimeException(e);
        }
    }

    private void add() throws InterruptedException {
        synchronized (myCounter) {
            while (myCounter.getCount() <= myCounter.getTime()){
                if (myCounter.fizzbuzz()) {
                    System.out.println("fizzbuzz");
                    myCounter.add();
                }
                else myCounter.pause();
            }
        }
    }
}

