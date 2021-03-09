package Task3;

public interface SomeFunc {
    double f(double x);
    public static double Derivative(double a,double b,double h, SomeFunc f){


        double min=f.f(a);
        for(double i=a;i<=b;i+=h){
            if(f.f(i)<min)
                min=f.f(i);
        }
        return min;
    }
}
