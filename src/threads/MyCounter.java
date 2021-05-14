package threads;

public class MyCounter {
    private int count=1;
    private int time;

    public MyCounter(int time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }
    public int getTime() {
        return time;
    }

    public void add(){
        count++;
        notifyAll();
    }

    public boolean fizz() {
        return count%3 == 0 && count% 5!= 0 && count != 0;
    }
    public boolean buzz(){
        return count%3 != 0 && count%5 == 0 && count != 0;
    }
    public boolean fizzbuzz(){
        return count%3 == 0 && count%5 == 0 && count != 0;
    }
    public void number() {
        System.out.println(count);
    }

    public void pause() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}