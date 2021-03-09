package Task4;

public class Array1 extends AbstractArrayOfPoints
{
    private double Arrs[][];
    int N=0;


    @Override
    // Запис нових координат точки:
    public void setPoint(int i, double x, double y) {


        Arrs[0][i]=x;
        Arrs[1][i]=y;
    }

    @Override
    public double getX(int i) {
        return Arrs[0][i];
    }

    @Override
    public double getY(int i) {
        return Arrs[1][i];
    }

    @Override
    public int count() {

        return N;
    }
    public void sex(double[][]a)
    {
        this.Arrs=a;
    }


    @Override
    public void addPoint(double x, double y) {
        N++;
        int K=N-1;
        if(N==1) {
            this.Arrs=new double[2][N];
            Arrs[0][0]=x;
            Arrs[1][0]=y;
        }
        else {
            double[][] temp = new double[2][N];
            for (int i = 0; i < Arrs.length; i++)
                for (int j = 0; j < Arrs[i].length;j++) {
                    temp[i][j] = Arrs[i][j];
                }
            temp[0][K]=x;
            temp[1][K]=y;
            Arrs=new double[2][N];
            for (int i = 0; i < temp.length; i++)
                for (int j = 0; j < temp[i].length;j++)
                {
                    Arrs[i][j] = temp[i][j];
                }
        }
    }

    @Override
    public void removeLast() {
        N--;
        int K = N - 1;
        double[][] temp = new double[2][N];
        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = Arrs[i][j];
            }
        Arrs = new double[2][N];
        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < temp[i].length; j++) {
                Arrs[i][j] = temp[i][j];
            }
    }
}
