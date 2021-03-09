package Task5;

import Task3.AcademicGroup;
import Task3.Student;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCreator {
    public static void Create(AcademicGroup R,String filename){
        try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(filename));
             DataOutputStream out = new DataOutputStream(zOut)) {
            for (Student c : R.getArr()) {
                ZipEntry zipEntry1 = new ZipEntry(c.getName());
                zOut.putNextEntry(zipEntry1);

                out.writeUTF(c.getSurname());
                out.writeUTF(c.getSpeciality());
                out.writeUTF(R.getGroup());
                zOut.closeEntry();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Read(String filename){
        try (ZipInputStream zIn = new ZipInputStream(new FileInputStream(filename));
             DataInputStream in = new DataInputStream(zIn)) {
            ZipEntry entry;
            while ((entry = zIn.getNextEntry()) != null) {
                System.out.println(
                        entry.getName()+ "\t " + in.readUTF()+ "\t " +in.readUTF() + "\t "+in.readUTF()+"\t");
                zIn.closeEntry();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
