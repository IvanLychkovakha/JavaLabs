package Task4;

public class Add{
    double sum=0;
    long count;
    public void add(long value) {
        Object lock= new Object();
        synchronized (lock) {
            this.sum+=value;
            this.count+=1;
        }
    }
}

