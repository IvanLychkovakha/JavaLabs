package Тask2;

public class Employee extends Citizen {
    protected String profession;
    Employee(){
        age=0;
        name=" ";
        country=" ";
        profession=" ";
    }
  public   Employee(int age, String name,String country,String profession){
        this.country=country;
        this.age=age;
        this.name=name;
        this.profession=profession;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Profession:"+profession);
    }
}
