package Тask1;

import java.util.*;

public class Doctor extends AbsDoctor {
    private ArrayList<Appointment> appArray;
    private String name;
    private String profession;
public Doctor(){}
    public Doctor(ArrayList<Appointment> appArray, String name, String profession) {
        this.appArray = appArray;
        this.name = name;
        this.profession = profession;
    }

    @Override
    public Appointment getAppointment(int index) {
        return appArray.get(index);
    }

    @Override
    public ArrayList<Appointment> getArrOfAppointment() {
        return appArray;
    }

    @Override
    public void setAppointments(ArrayList<Appointment> appointments) {
        appArray = appointments;
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

    @Override
    public Doctor sortByDate() {
        for (int i = 0; i < appArray.size(); i++) {
            int maxID = i;
            Appointment maxAppointment = appArray.get(i);
            for (int j = i; j < appArray.size(); j++) {
                if (maxAppointment.getDate().before(appArray.get(j).getDate())) {
                    maxAppointment = appArray.get(j);
                    maxID = j;
                }
            }
            Appointment tempApp = appArray.get(i);
            appArray.set(i, maxAppointment);
            appArray.set(maxID, tempApp);
        }
        return this;
    }

    @Override
    public Doctor sortByVisitors() {
        Collections.sort(appArray);
        return this;
    }
}
