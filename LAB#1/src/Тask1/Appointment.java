package Тask1;

import java.util.Date;

public class Appointment extends AbsAppointment {

    private Date date;
    private Integer numOfVisitors;
    private Integer shift;

    public Appointment(Date date, Integer numOfVisitors, Integer shift) {
        this.date = date;
        this.numOfVisitors = numOfVisitors;
        this.shift = shift;
    }

    public Appointment() {}

    @Override
    public Date getDate() {

        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Integer getShift() {
        return shift;
    }

    @Override
    public void setShift(Integer shift) {
        this.shift = shift;
    }

    @Override
    public Integer getNumOfVisitors() {
        return numOfVisitors;
    }

    @Override
    public void setNumOfVisitors(Integer numOfVisitors) {
        this.numOfVisitors = numOfVisitors;
    }
}
