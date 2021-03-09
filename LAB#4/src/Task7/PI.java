package Task7;

public class PI implements Runnable{
    private double E;
    static private int count = 0;
    static private double pi = 0;

    public PI(double e) {
        this.E = e;
    }

    @Override
    public void run() {
        try {
            double i = 1, ch1, ch2;
            while (pi > this.E || count == 0) {
                this.count++;
                ch1 = 1 / (i + 2);
                ch2 = 1 / (i + 4);
                pi = 4 / i - ch1;
                pi += ch2;
                i += 2;
                show();
                Thread.sleep(50);
            }
            //Thread.yield();
        } catch (Exception e) {
            System.out.println("Неверные данные!");
        }
    }

    public void show() {
        System.out.printf("Колличество посчитаных элементов: %d     Pi = %6.4f\n", count, pi);
    }
}
