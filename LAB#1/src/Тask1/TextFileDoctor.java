package Тask1;
import java.io.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class TextFileDoctor extends Doctor implements FileIO {


    @Override
    public void readFromFile(String fileName) throws FileNotFoundException, InputMismatchException {
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            setName(scanner.next());
            setProfession(scanner.next());

            while (scanner.hasNext()) {
                SimpleDateFormat FORM = new SimpleDateFormat("yyyy-MM-dd");

                Integer numOfVisitors = scanner.nextInt();
                Integer shift = scanner.nextInt();
                Date date = FORM.parse("2019-10-26", new ParsePosition(0));
                addAppointment(new Appointment(date,numOfVisitors, shift ));
            }
        }
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println(getName() + " " + getProfession());
            for (AbsAppointment appointment : getArrOfAppointment()) {
                out.print(appointment.getShift() + " " + appointment.getNumOfVisitors());
                out.println(appointment.getDate());
            }
        }

    }
    public static void main(String[] args) {
        TextFileDoctor country = new TextFileDoctor();
        try {
            country.readFromFile("Temp1.txt");

            country.writeToFile("Temp2.txt");
        }
        catch (FileNotFoundException e) {
            System.err.println("Read failed");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println("Write failed");
            e.printStackTrace();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
            System.err.println("Wrong format");
        }
    }

}



