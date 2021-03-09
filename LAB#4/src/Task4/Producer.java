package Task4;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    int countToAdd;
    public Producer (BlockingQueue<Integer> queue, int countToAdd ) {
        this.queue=queue;
        this.countToAdd=countToAdd;
    }
    public void run() {
        try {
            for(int i=1;i<=countToAdd; i++) {
                queue.put(i);
                System.out.printf("Додавання: %d%n",i);
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){
            System.out.println("Помилка");
        }
    }

}

