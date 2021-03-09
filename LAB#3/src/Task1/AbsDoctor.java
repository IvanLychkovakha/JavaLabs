package Task1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public abstract class AbsDoctor {
    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getProfession();

    public abstract int appointmentCount();

    public abstract void setProfession(String profession);

    public abstract AbsAppointment getAppointment(int index);

    public abstract void setAppointments(int i,AbsAppointment appointments);

    public abstract boolean addAppointment(AbsAppointment census);

    public abstract boolean addAppointment(Date date, Integer numOfVisitors, Integer shift);

    public abstract void sortByDate();

    public abstract void sortByVisitors();

    public abstract AbsAppointment[] getAppointment();

    public static AbsAppointment[] addToArray(AbsAppointment[] arr,AbsAppointment item){
        AbsAppointment[] newArr;
        if(arr!=null){
            newArr= new AbsAppointment[arr.length+1];
            System.arraycopy(arr,0,newArr,0,arr.length);
        }
        else {
            newArr=new AbsAppointment[1];
        }
        newArr[newArr.length-1]=item;
        return newArr;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj instanceof AbsDoctor)
            return false;

        AbsDoctor d = (AbsDoctor) obj;
        return Arrays.equals(getAppointment(),d.getAppointment());
    }
    @Override
    public String toString() {
       String result = getName() + ". Profession: "+ getProfession();
       for(int i=0;i<appointmentCount();i++){
           result += "\n"+ getAppointment(i);
       }
       return result;
    }

    public int getAllVisitor() {
        int count = 0;
        for (int i=0;i<appointmentCount();i++)
            count += getAllVisitor();
        return count;
    }

    public int minVisitors() {
        AbsAppointment census = getAppointment(0);
        for (int i = 1; i < appointmentCount(); i++) {
            if (census.getNumOfVisitors() > getAppointment(i).getNumOfVisitors()) {
                census = getAppointment(i);
            }
        }
        return census.getNumOfVisitors();
    }

    public int lenghOfName() {
        return getName().length();
    }




}
