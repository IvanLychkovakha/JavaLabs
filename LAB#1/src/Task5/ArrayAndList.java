package Task5;

import java.lang.reflect.Array;
import java.util.List;

public class ArrayAndList {

    public static <T> T[] ArrayCopy(T[] a) {
        T[] temp = (T[]) Array.newInstance(a.getClass().getComponentType(), (a.length));
        System.arraycopy(a, 0, temp, 0, temp.length);
        return temp;

    }
    public static <T> void ListCopy(List<T> a,List<T>b)
    {
        if(a.size()!=b.size())
        {
            for(int i=a.size();i<b.size();i++)
            {
                a.set(i,a.get(0));
            }
        }
        for(int i=0;i<a.size();i++)
        {
            a.set(i,b.get(i));
        }
    }

    public static<T> void print(T[]a)
    {
        for(T i:a)
            System.out.print(i+" ");
        System.out.println();
    }
    public static<T>T[] InsertArr(T[]a,T[]b,int c)
    {
        T[] temp = (T[])Array.newInstance(a.getClass().getComponentType(),(c-1+b.length));
        System.arraycopy(a,0,temp,0,(c-1));
        System.arraycopy(b,0,temp,(c-1),b.length);
        return temp;
    }
    public static<T>void InsertList(List<T> a,List<T> b,int c)
    {

        int j=0;
        for(int i=a.size();i<(c-2+b.size());i++)
        {
            a.add(i,a.get(0));
        }
        for(int i=(c-1);i<a.size();i++)
        {
            a.set(i,b.get(j));
            j++;
        }
    }
    public static <T> void InvertArr(T[] a, T[] b, int c) {
        c -= 1;
        T temp = a[c];
        T temp1 = b[c];
        b[c] = temp;
        a[c] = temp1;
    }

    public static <T> void InvertList(List<T> a, List<T> b, int c) {
        c -= 1;
        T temp = a.get(c);
        a.set(c, b.get(c));
        b.set(c, temp);
    }
    public static <T> void SwapArr(T[]a)
    {
        int k=a.length;
        if(a.length%2!=0)
        {
            k--;
        }
        for(int i=0;i<k;i+=2)
        {
            T temp=a[i];
            a[i]=a[(i+1)];
            a[(i+1)]=temp;
        }
    }
    public static <T> void SwapList(List<T> a)
    {
        int k=a.size();
        if(a.size()%2!=0)
        {
            k--;
        }
        for(int i=0;i<k;i+=2)
        {
            T temp=a.get(i);
            a.set(i,a.get((i+1)));
            a.set((i+1),temp);
        }
    }
}
