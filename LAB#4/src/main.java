import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import Task4.*;
import Task7.PI;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choise;
        do {
            System.out.println("Введите номер задания(2,4,7)\n");
            choise = scanner.nextInt();

            switch (choise) {
                case 2:{
                    System.out.print("Введите полное имя класса: ");
                    String className = new Scanner(System.in).next();
                    try {
                        Class<?> c=Class.forName(className);
                        for(Field f: c.getDeclaredFields()) {
                            System.out.println("Имя: "+f.getName()+".\tТип: "+f.getType()+".\tМодификатор доступа: "+ Modifier.toString(f.getModifiers()));
                        }
                        for (Method m : c.getMethods()) {
                            System.out.printf("Имя: %s Тип результату: %s%n", m.getName(), m.getReturnType().getCanonicalName());
                            for (Class<?> type : m.getParameterTypes()) {
                                System.out.printf("  .\tТип параметра: %s%n", type.getCanonicalName());
                            }
                        }
                    }
                    catch(ClassNotFoundException e) {
                        System.err.println("Ошибка ввода имени класса!");
                    }
                    break;
                }
                case 4:{
                    Add adder = new Add();
                    BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
                    Thread producerThread=new Thread(new Producer(queue,50));
                    Thread consumerThread=new Thread(new Consumer(queue,50,adder));
                    producerThread.start();
                    consumerThread.start();
                    Thread.sleep(10000);
                    producerThread.interrupt();
                    break;
                }
                case 7:{
                    try {
                        System.out.print("Введите точность: ");
                        double E = new Scanner(System.in).nextDouble();
                        Thread thread = new Thread(new PI(E));
                        thread.start();
                        while (true){
                            String q =new Scanner(System.in).next();

                        }
                    } catch (Exception e) {
                        System.out.println("Неверные данные!");
                    }
                    break;
                }


            }
        } while (choise != 0);
    }
}