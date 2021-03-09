package Task4;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private Add counter=null;
    int countToTake;
    public Consumer (BlockingQueue<Integer> queue,int countToTake,Add counter ) {
        this.queue=queue;
        this.countToTake=countToTake;
        this.counter=counter;
    }
    public void run() {
        try {
            double average;
            for(int i=1;i<=countToTake;i++) {
                counter.add(queue.take());
                average=counter.sum/counter.count;
                System.out.println("Середнє арифметичне: "+average);
            }
        }
        catch(InterruptedException e) {
            System.out.println("Помилка");
        }
    }
}
