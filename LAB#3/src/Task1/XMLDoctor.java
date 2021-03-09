package Task1;
import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class XMLDoctor extends AbsDoctor implements FileIO {
    private DoctorData doctorData= new DoctorData();
    @Override
    public String getName() {
        return doctorData.getName();
    }

    @Override
    public void setName(String name) {
        doctorData.setName(name);
    }

    @Override
    public String getProfession() {
        return doctorData.getProfession();
    }

    @Override
    public void setProfession(String profession) {
       doctorData.setProfession(profession);
    }

    @Override
    public AbsAppointment getAppointment(int i) {
        return new XMLAppointment(doctorData.getAppointmentData().get(i));
    }

    @Override
    public void setAppointments(int i, AbsAppointment appointment) {
        doctorData.getAppointmentData().get(i).setNumOfVisitors(appointment.getNumOfVisitors());
        doctorData.getAppointmentData().get(i).setDate(appointment.getDate());
        doctorData.getAppointmentData().get(i).setShift(appointment.getShift());
    }

    @Override
    public boolean addAppointment(AbsAppointment appointment) {
        DoctorData.AppointmentData appointmentData = new DoctorData.AppointmentData();
        boolean result =doctorData.getAppointmentData().add(appointmentData);
        setAppointments(appointmentCount() - 1, appointment);
        return result;
    }

    @Override
    public boolean addAppointment(Date date, Integer numOfVisitors, Integer shift) {
        DoctorData.AppointmentData appointmentData = new  DoctorData.AppointmentData();
        appointmentData .setDate(date);
       appointmentData.setNumOfVisitors(numOfVisitors);
        appointmentData .setShift(shift);
        return doctorData.getAppointmentData().add(appointmentData);
    }
    @Override
     public int appointmentCount() {
        return doctorData.getAppointmentData().size();
    }



    @Override
    public void sortByDate() {

    /*   for (int i = 0; i < appointmentCount(); i++) {
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
        SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
        Collections.sort(doctorData.getAppointmentData(),
                Comparator.comparing(DoctorData.AppointmentData::getDate));

    }

    @Override
    public void sortByVisitors() {
        Collections.sort(doctorData.getAppointmentData(),
                Comparator.comparing(DoctorData.AppointmentData::getNumOfVisitors));

    }

    @Override
    public AbsAppointment[] getAppointment() {
        AbsAppointment[] absAppointment = new AbsAppointment[appointmentCount()];
        for (int i = 0; i < appointmentCount(); i++) {
            absAppointment[i] = new XMLAppointment(doctorData.getAppointmentData().get(i));
        }
        return absAppointment;
    }


    @Override
    public void readFromFile(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DoctorData.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        doctorData = (DoctorData) unmarshaller.unmarshal(new FileInputStream(fileName));
    }

    @Override
    public void writeToFile(String fileName) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DoctorData.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(doctorData, new FileWriter(fileName));
    }
    public void clearAppointments() {
        doctorData.getAppointmentData().clear();
    }


   /* public static void main(String[] args) {
        XMLDoctor country = new XMLDoctor();
        try {
            country.readFromFile("Temp3.xml");
            country.sortByVisitors();
            country.writeToFile("ByComments.xml");
        }
        catch (FileNotFoundException e) {
            System.out.println("Read failed");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Write failed");
            e.printStackTrace();
        }
        catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("Wrong format");
        }
    }*/
}
