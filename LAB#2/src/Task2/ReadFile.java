package Task2;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

import static java.lang.StrictMath.round;

public class ReadFile {
    public static Comparator<Integer> comareByIncrease() {
        class LocalComparator implements Comparator<Integer> {

            @Override

            public int compare(Integer d1, Integer d2) {
                return Integer.compare(d1, d2);

            }
        }
        return new LocalComparator();
    }

    public static Comparator<Integer> comareByDecrease() {
        class LocalComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer d1, Integer d2) {
                return Integer.compare(d2, d1);
            }
        }
        return new LocalComparator();
    }
    public static int test(String value){


            if(value.contains(".")||value.contains(",")) {
                value.replace(",",".");
                double a = Double.valueOf(value);

                return (int)round(a);


            }
            else  {
                if(Integer.parseInt(value)<0 ) {
                    return Math.abs(Integer.parseInt(value));
                }
                else {
                    return Integer.parseInt(value);
                }
            }
    }


    public static void sortIntegers(String inFileName, String firstOutFileName, String secondOutFileName)
            throws IOException, InputMismatchException {
        Integer[] arr = {};
        try (BufferedReader reader = new BufferedReader(new FileReader(inFileName));
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                String value1 = scanner.next();
                int value= test(value1);

                Integer[] arr1 = new Integer[arr.length + 1];
                System.arraycopy(arr, 0, arr1, 0, arr.length);
                arr1[arr.length] = value;
                arr = arr1;
            }
        }
        PrintWriter firstWriter = new PrintWriter(new FileWriter(firstOutFileName));
        PrintWriter secondWriter = new PrintWriter(new FileWriter(secondOutFileName));
        try {
            int m=1;
            for(int i=0;i<arr.length;i++){

                if(arr[i]%2==0&& arr[i]!=0){
                   m *=arr[i];


                }


            }
            firstWriter.print(m);
         /*   Arrays.sort(arr, comareByIncrease());
            for (Integer x : arr)
                firstWriter.print(x + " ");*/
            Arrays.sort(arr, comareByDecrease());
            for (Integer x : arr)
                secondWriter.print(x + " ");
        } finally {
            firstWriter.close();
            secondWriter.close();
        }
    }
}


