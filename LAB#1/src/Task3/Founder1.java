package Task3;

import java.util.Scanner;

public abstract class Founder1 {
    abstract double f(double x);
  public   double Derivative(double a,double b,double h){

      /*  System.out.println("All:");
        for(double i=a;i<=b;i+=h){
            System.out.println(f(i)+" ");
        }*/
        double min=f(a);
        for(double i=a;i<=b;i+=h){
            if(f(i)<min)
                min=f(i);
        }
      //  System.out.println("Min:"+min);
      return min;
    }

}