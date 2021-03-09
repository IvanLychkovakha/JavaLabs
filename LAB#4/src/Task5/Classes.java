package Task5;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Classes {

    public static void main(String[] args) {
        System.out.print("Введіть ім*я класу: ");
        String className = new Scanner(System.in).next();
        try {
            Class<?> c=Class.forName(className);
            Object obj = c.newInstance();
            Method method = c.getMethod("printing");
            method.invoke(obj);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
