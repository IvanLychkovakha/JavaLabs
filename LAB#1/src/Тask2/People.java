package Тask2;

public class People {
    protected int age;
    protected   String name;
    People() {
        age = 0;
        name = " ";
    }
    public People(int age, String name){
        this.age=age;
        this.name=name;
    }
  public   void display(){
        System.out.println("Имя:"+ name);
        System.out.println("Возраст:"+age);
    }
}
