package Тask1;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbsAppointment implements Comparable<AbsAppointment> {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public abstract Date getDate();

    public abstract void setDate(Date date);

    public abstract Integer getShift();

    public abstract void setShift(Integer shift);

    public abstract Integer getNumOfVisitors();

    public abstract void setNumOfVisitors(Integer numOfVisitors);

    @Override
    public String toString() {
        return "Appointment" +
                "\n Date: " + FORMATTER.format(getDate()) +
                "\n Shift: " + getShift() +
                "\n NumOfVisitors: " + getNumOfVisitors() +
                "\n ";
    }

    @Override
    public int compareTo(AbsAppointment o) {
        return Integer.compare(getNumOfVisitors(), o.getNumOfVisitors());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof AbsDoctor))
            return false;

        AbsAppointment a = (AbsAppointment) obj;
        return getDate().equals(a.getDate()) && getNumOfVisitors().equals(getNumOfVisitors()) && getShift().equals(a.getShift());
    }
}
