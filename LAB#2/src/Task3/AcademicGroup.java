package Task3;

import java.io.Serializable;

public class AcademicGroup implements Serializable {
    private static final long serialVersionUID= 6813139800385531481L;
    private String group;
    private Student[] arr;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public Student getStudent(int i) {
        return arr[i];
    }
    public AcademicGroup(){}

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student[] getArr() {
        return arr;
    }

    public void setArr(Student[] arr) {
        this.arr = arr;
    }

    public AcademicGroup(String group, Student... arr) {
        this.arr = arr;
        this.group = group;


    }

    public String toString(){
        String result="Група"+getGroup();
        for (int i=0; i<getArr().length;i++  ) {
            result+=".\n"+getStudent(i);
        }
        return result;
    }

}
