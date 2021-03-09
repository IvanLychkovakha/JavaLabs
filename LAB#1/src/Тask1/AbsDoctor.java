package Тask1;

import java.util.ArrayList;

public abstract class AbsDoctor {

    public abstract Appointment getAppointment(int index);

    public abstract ArrayList<Appointment> getArrOfAppointment();

    public abstract void setAppointments(ArrayList<Appointment> appointments);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getProfession();

    public abstract void setProfession(String profession);

    public abstract Doctor sortByDate();

    public abstract Doctor sortByVisitors();

    public void addAppointment(Appointment newAppointment) {
        for (Appointment a : getArrOfAppointment())
            if (newAppointment == a)
                return;
        getArrOfAppointment().add(newAppointment);
    }

    public int getAllVisitor() {
        int count = 0;
        for (Appointment a : getArrOfAppointment())
            count += a.getNumOfVisitors();
        return count;
    }

    public int minVisitors() {
        int min = getAppointment(0).getNumOfVisitors();
        for (Appointment a : getArrOfAppointment())
            if (min > a.getNumOfVisitors())
                min = a.getNumOfVisitors();
        return min;
    }

    public int lenghOfName() {
        return getName().length();
    }

    @Override
    public String toString() {
        return "Doctor" +
                "\n Name: " + getName() +
                "\n Profession: " + getProfession()
                +"\n"+
                getArrOfAppointment()
                +"\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj instanceof AbsDoctor)
            return false;

        AbsDoctor d = (AbsDoctor) obj;
        return getName().equals(d.getName()) && getProfession().equals(d.getProfession()) && getArrOfAppointment().equals(d.getArrOfAppointment());
    }
}
