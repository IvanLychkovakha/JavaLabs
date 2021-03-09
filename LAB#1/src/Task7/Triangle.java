package Task7;

public class Triangle {
    private double a,b,c;
    private  double S;

    public double getS() {
        return S;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", S=" + S +
                '}';
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        S=0.25*Math.sqrt((this.a+this.b+this.c)*(this.b+this.c-this.a)*(this.a+this.c-this.b)*(this.a+this.b-this.c));
    }
}