package threads;

public class MyCounter {
    private int count=1;
    private int time=20;

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
        System.out.println(" call ADD from "+Thread.currentThread().getName()+". count = "+count);
        count++;
        notifyAll();
    }

    public boolean fizz() {
        return count % 3 == 0 && count != 0;
    }
    public boolean buzz(){
        return count % 5 == 0 && count != 0;
    }
    public boolean fizzbuzz(){
        return (fizz() && buzz() && count != 0);
    }
    public void number() {
        System.out.println(count);
    }

}