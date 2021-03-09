package Task4;

public class Array2 extends AbstractArrayOfPoints {
    int N;
    double[]Arr;
    @Override
    public void setPoint(int i, double x, double y) {
        i*=2;
        Arr[i]=x;
        i+=1;
        Arr[i]=y;;
    }

    @Override
    public double getX(int i) {
        i*=2;
        return Arr[i];
    }

    @Override
    public double getY(int i) {

        i*=2;
        i+=1;
        return Arr[i];
    }

    @Override
    public int count() {
        return Arr.length/2;
    }

    @Override
    public void addPoint(double x, double y) {
        N+=2;
        int K=N-2;
        if(N==2)
        {
            Arr=new double[N];
            Arr[K]=x;
            K+=1;
            Arr[K]=y;
        }
        else
        {
            double[]temp=new double[N];
            System.arraycopy(Arr,0,temp,0,Arr.length);
            temp[K]=x;
            K+=1;
            temp[K]=y;
            Arr=new double[N];
            System.arraycopy(temp,0,Arr,0,temp.length);
        }
    }

    @Override
    public void removeLast() {
        N-=2;
        double[]temp=new double[N];
        System.arraycopy(Arr,0,temp,0,temp.length);
        Arr=new double[N];
        System.arraycopy(temp,0,Arr,0,temp.length);

    }
}
