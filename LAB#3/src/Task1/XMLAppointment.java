package Task1;
import java.math.BigInteger;
import java.util.Date;

public class XMLAppointment extends AbsAppointment {
   DoctorData.AppointmentData AppointmentData;
    public XMLAppointment( DoctorData.AppointmentData AppointmentData) {
        this.AppointmentData = AppointmentData;
    }

    @Override
    public Date getDate() {
        return AppointmentData.getDate();
    }

    @Override
    public void setDate(Date date) {
        AppointmentData.setDate(date);
    }

    @Override
    public Integer getNumOfVisitors() {
        return AppointmentData.getNumOfVisitors();
    }

    @Override
    public void setNumOfVisitors(Integer NumOfVisitors) {
        AppointmentData.setNumOfVisitors(NumOfVisitors);
    }

    @Override
    public Integer getShift() {
        return AppointmentData.getShift();
    }

    @Override
    public void setShift(Integer shift) {
         AppointmentData.setShift(shift);
    }

}
