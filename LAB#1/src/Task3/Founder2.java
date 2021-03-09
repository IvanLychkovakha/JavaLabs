package Task3;

public class Founder2 extends Founder1 implements SomeFunc {
   public double f(double x) {
        double f = 29.7 * x * x * Math.sin(x) + 1;
        return f;
    }
}