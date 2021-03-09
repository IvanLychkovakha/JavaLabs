package Task1;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor extends AbsDoctor {
    private AbsAppointment[] appArray;
    private String name;
    private String profession;

    public Doctor(){}
    public Doctor(AbsAppointment[] appArray, String name, String profession) {
        this.appArray = appArray;
        this.name = name;
        this.profession = profession;
    }

    @Override
    public AbsAppointment getAppointment(int index) {
        return appArray[index];
    }



    @Override
    public void setAppointments(int i,AbsAppointment appointments) {
        appArray[i]=appointments;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfession() {
        return profession;
    }

    @Override
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override public int appointmentCount() {
        return appArray.length;
    }


    public void clearAppArray() {
        appArray = null;
    }

    @Override
    public AbsAppointment[] getAppointment() {
        return appArray;
    }


    public void setAppArray(AbsAppointment[] appArray) {
        this.appArray = appArray;
    }


    @Override
    public boolean addAppointment(AbsAppointment app) {
        if (getAppointment() != null) {
            for (AbsAppointment c : getAppointment()) {
                if (c.equals(app)) {
                    return false;
                }
            }
        }
        setAppArray(addToArray(getAppointment(), app));
        return true;
    }



    @Override public boolean addAppointment(Date date, Integer numOfVisitors, Integer shift) {
       AbsAppointment app = new Appointment( date,  numOfVisitors,  shift);
        return addAppointment(app);
    }

    @Override
    public void sortByDate() {
       /* for (int i = 0; i < appointmentCount(); i++) {
            int maxID = i;
            AbsAppointment maxAppointment = getAppointment(i);
            for (int j = i; j < appointmentCount(); j++) {
                if (maxAppointment.getDate().before(getAppointment(j).getDate())) {
                    maxAppointment = getAppointment(j);
                    maxID = j;
                }
            }
            AbsAppointment tempApp = getAppointment(i);
           setAppointments(i, maxAppointment);
            setAppointments(maxID, tempApp);
        }
        return this;*/

        Arrays.sort(appArray);
    }

    @Override
    public void sortByVisitors() {
        Arrays.sort(appArray);

    }
}