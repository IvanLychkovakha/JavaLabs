import Тask1.*;
import Task4.*;
import Task5.*;
import Тask2.*;
import Task3.*;
import Task6.*;
import Task7.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int choise;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Введите номер задания(1-7)\n");
            choise = scanner.nextInt();
            switch (choise) {
                case 1:{
                    SimpleDateFormat Date= new SimpleDateFormat("yyyy-MM-dd");
                    ArrayList<Appointment>  arr = new ArrayList<>();
                    arr.add(new Appointment(Date.parse("2019-10-02",new ParsePosition(0)),4,2));
                    arr.add(new Appointment(Date.parse("2019-09-15",new ParsePosition(0)),6,2));
                    arr.add(new Appointment(Date.parse("2019-10-01",new ParsePosition(0)),2,1));
                    Doctor Doctor=new Doctor(arr,"Ivan","surgeon");
                    System.out.println("Info about the Doctor: \n"+Doctor+"\n");
                    System.out.println("Sorted by date: \n"+Doctor.sortByDate()+"\n");
                    System.out.println("Sorted by visitors: \n"+Doctor.sortByVisitors()+"\n");
                    System.out.println("Min count of visitors: \n"+Doctor.minVisitors());
                    System.out.println("Count of lengh: \n"+Doctor.lenghOfName());
                    break;
                }
                case 2: {
                    int age;
                    String name,country, group, proffession;
                    int N = 4;
                    People[] arr = new People[4];
                    System.out.println("Enter age and name");
                    arr[0] = new People(scanner.nextInt(), scanner.next());
                    System.out.println("Enter age,name and country");
                    arr[1] = new Citizen(scanner.nextInt(), scanner.next(), scanner.next());
                    System.out.println("Enter age,name,country, group");
                    arr[2] = new Student(scanner.nextInt(), scanner.next(), scanner.next(),scanner.next());
                    System.out.println("Enter age,name, country, Profession");
                    arr[3] = new Employee(scanner.nextInt(), scanner.next(), scanner.next(),scanner.next());
                    for (int i = 0; i < 4; i++)
                        arr[i].display();
                    break;
                }
                case 3:{
                    System.out.println("Введите начало, конец отрезка и шаг");
                    double a=scanner.nextDouble();
                    double b=scanner.nextDouble();
                    double h=scanner.nextDouble();
                    System.out.println("Реализация через абстрактный клас");
                    Founder2 func = new Founder2();
                    System.out.println("Min:"+ func.Derivative(a,b,h));
                    System.out.println("Реализация через передачу интерфейса в качестве параметра");
                    System.out.println("Min:"+SomeFunc.Derivative(a, b, h,new Founder2()));
                    System.out.println("Реализация через безымяный класс, фукнция Х*Х");
                    System.out.println(SomeFunc.Derivative(a, b, h,new Founder2(){
                        public double f(double x)
                        {
                            return x*x;
                        }
                    }));
                    System.out.println("Реализация через лямбда выражения фукнция Х*Х");
                    System.out.println(SomeFunc.Derivative(a, b, h,(x)-> x*x+10));
                    System.out.println("Реализация через ссылку на метод");
                    System.out.println(SomeFunc.Derivative(a, b, h,new Founder2()::f));


                    break;
                }
                case 4:{
                    System.out.println("Реализация через двумерный массив");
                    new Array1().test();
                    System.out.println("Реализация через одномерный массив");
                    new Array2().test();
                    break;
                }
                case 5:{
                    System.out.println("Введите размерности массивов");
                    int k =scanner.nextInt();
                  //  int kk =scanner.nextInt();
                    Double[] Array1=new Double[k];
                    Double[] Array2=new Double[k];
                    for(int i=0;i<k;i++)
                    {
                        System.out.println("Введите значение");
                        Array1[i]=scanner.nextDouble();
                    }
                    System.out.println("Первый масив заполнен");
                    for(int i=0;i<k;i++)
                    {
                        System.out.println("Введите значение");
                        Array2[i]=scanner.nextDouble();

                    }
                    System.out.println("Второй масив заполнен");
                    System.out.println("Два массива (Double)");



                    System.out.println("Обмен местами двух елементов по индексу,индекс для двух масивов общий");
                    System.out.println("Введите индекс не больше размера масива ");
                    int q=scanner.nextInt();
                    ArrayAndList.InvertArr(Array1,Array2,q);
                    ArrayAndList.print(Array1);
                    ArrayAndList.print(Array2);
                    //
                    System.out.println("Обмен местами пар елементов с четным и нечетным индексом");
                    ArrayAndList.SwapArr(Array1);
                    ArrayAndList.SwapArr(Array2);
                    ArrayAndList.print(Array1);
                    ArrayAndList.print(Array2);
                    System.out.println("Вставка елементов 2 масива в 1 масив от указаного индекса");
                    System.out.println("Введите индекс не больше размера масива");
                    q=scanner.nextInt();
                    Array1=ArrayAndList.InsertArr(Array1,Array2,q);
                    ArrayAndList.print(Array1);
                    ArrayAndList.print(Array2);
                    //
                    System.out.println("Замена елементов 1 масива 2 масивом");
                    Array1= ArrayAndList.ArrayCopy(Array2);
                   ArrayAndList.print(Array1);

                    System.out.println("Список");
                    List<String> list1=new LinkedList<>();
                    List<String> list2=new LinkedList<>();
                    for(int i=0;i<k;i++)
                    {
                        System.out.println("Введите значение");
                        String temp=scanner.next();
                        list1.add(temp);
                    }
                    System.out.println("Первый список заполнен");
                    for(int i=0;i<k;i++)
                    {
                        System.out.println("Введите значение");
                        String temp=scanner.next();
                        list2.add(temp);
                    }
                    System.out.println("Два списка типа String");
                    System.out.println(list1);
                    System.out.println(list2);

                    System.out.println("Обмен местами двух елементов по индексу,индекс для двух масивов общий");
                    System.out.println("Введите индекс не больше размера масива ");
                     q=scanner.nextInt();
                    ArrayAndList.InvertList(list1,list2,q);
                    System.out.println(list1);
                    System.out.println(list2);

                    System.out.println("Обмен местами пар елементов с четным и нечетным индексом");
                    ArrayAndList.SwapList(list1);
                    ArrayAndList.SwapList(list2);
                    System.out.println(list1);
                    System.out.println(list2);

                    System.out.println("Вставка елементов 2 cписка в 1 список от указаного индекса");
                    System.out.println("Введите индекс не больше размера cписка");
                    q=scanner.nextInt();
                    ArrayAndList.InsertList(list1,list2,q);
                    System.out.println(list1);
                    System.out.println(list2);

                    System.out.println("Замена елементов 1 cписка 2 списком");
                    ArrayAndList.ListCopy(list1,list2);
                    System.out.println(list1);
                    System.out.println(list2);

                    break;
                }
                case 6: {
                    TreeSet<Circle> myCircleArrayList = new TreeSet<Circle>();
                    double[] arrR= new double[3];
                    System.out.println("Введите радиусы колец:");
                    for(int i=0;i<3;i++){
                        arrR[i]=scanner.nextDouble();
                        myCircleArrayList.add(new Circle(arrR[i]));
                    }
                    for(Circle h: myCircleArrayList){
                        System.out.println(h);
                    }
                    break;
                }
                case 7:{
                    ArrayList<Triangle> myTriangleArrayList = new ArrayList<Triangle>();
                    double a,b,c;

                    for(int i=0;i<3;i++){
                        System.out.println("Введите стороны треугольника:");
                        a=scanner.nextDouble();
                        b=scanner.nextDouble();
                        c=scanner.nextDouble();
                        if(a==0||b==0||c==0){

                            System.out.println("all argument 0");
                            break;
                        }else {
                            if (a + b < c || a + c < b || b + c < a) {
                                System.out.println("Треугольник не существует");
                                break;

                            }else{
                                myTriangleArrayList.add(new Triangle(a, b, c));
                            }
                        }

                    }

                    AreaComparator myAreaComparator = new AreaComparator();
                    myTriangleArrayList.sort(myAreaComparator);
                    for(Triangle h: myTriangleArrayList){
                        System.out.println(h);
                    }
                    break;
                }
            }
        }while (choise!=0);
    }
}
