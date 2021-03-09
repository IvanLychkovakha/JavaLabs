package Тask2;

 public class Citizen extends People {
    protected String country;
    Citizen(){
        age=0;
        name=" ";
        country=" ";
    }
    public Citizen(int age, String name, String country){
        this.country=country;
        this.age=age;
        this.name=name;
    }

    @Override
   public void display() {
        super.display();
        System.out.println("Country:"+country);
    }
}