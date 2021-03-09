package Task3;

import java.beans.XMLDecoder;
import java.io.*;

public class DataDeserializable {
    public static void DataDeserializable(String filename) throws ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            AcademicGroup Group2 = (AcademicGroup) in.readObject();
            for (Student c : Group2.getArr()) {
                System.out.println(
                        c.getName() + "\t " + c.getSurname() + "\t " + c.getSpeciality() + "\t "+Group2.getGroup()+"\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void XMLDeserializable(String filename) throws ClassNotFoundException{
        try (XMLDecoder in = new XMLDecoder(new FileInputStream(filename))) {
            AcademicGroup Group = (AcademicGroup) in.readObject();
            for (Student c : Group.getArr()) {
                System.out.println(
                        c.getName() + "\t " + c.getSurname() + "\t " + c.getSpeciality() + "\t "+Group.getGroup()+"\t");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
