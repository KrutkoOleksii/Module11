package threads;

public class Main {
    private static Integer count = 0;
    private static final int TIME = 22;

    public static void main(String[] args) {
        // task #1
        System.out.println(" - - Task #1 - - ");
        runFirstProgram();

        // task #2
        System.out.println("\n - - Task #2 - - ");

        MyCounter myCounter = new MyCounter(20);
        ThreadA threadA = new ThreadA(myCounter);
        ThreadB threadB = new ThreadB(myCounter);
        ThreadC threadC = new ThreadC(myCounter);
        ThreadD threadD = new ThreadD(myCounter);
        new Thread(threadA,"ThA").start();
        new Thread(threadB,"ThB").start();
        new Thread(threadC,"ThC").start();
        new Thread(threadD,"ThD").start();

    }

    private static void runFirstProgram() {
        count = 0;
        Thread myThread = new Thread(() -> {
            synchronized (Thread.currentThread()) {
                while(count < TIME) {
                    try {
                        if (count % 5 == 0 && count != 0) System.out.println("Прошло 5 секунд");
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //System.out.println("Подчиненный поток завершен");
            }
        });
        myThread.start();
        while (count < TIME) {
            try {
                Thread.sleep(1000);
                System.out.println(++count);
                synchronized (myThread) {
                    myThread.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Основной поток завершен");
    }

}
