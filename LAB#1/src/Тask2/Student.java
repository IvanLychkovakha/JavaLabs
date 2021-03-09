package Тask2;

public class Student extends  Citizen {
    protected String group;
    Student() {
        age = 0;
        name = " ";
        country = " ";
        group=" ";
    }
  public   Student(int age, String name,String country,String group){
        this.country=country;
        this.age=age;
        this.name=name;
        this.group=group;
    }

    @Override
  public   void display() {
        super.display();
        System.out.println("Group:"+group);
    }
}
