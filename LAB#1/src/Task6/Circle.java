package Task6;

public class Circle implements Comparable<Circle>{
    private double radius;
    private double length;

    public Circle(double radius) {
        this.radius = radius;
        length= 2*radius* Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", length=" + length +
                '}';
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public double getRadius() {
        return radius;
    }

    public int compareTo(Circle anyCircle){
        if (this.radius == anyCircle.radius) {
            return 0;
        } else if (this.radius < anyCircle.radius) {
            return -1;
        } else {
            return 1;
        }
    }
}
