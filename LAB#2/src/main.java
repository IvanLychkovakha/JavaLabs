import Task6.*;
import Task3.*;
import Task4.*;
import Task5.ZipCreator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Task2.ReadFile.sortIntegers;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choise;
        do {
            System.out.println("Введите номер задания(2-6)\n");
            choise = scanner.nextInt();
            switch (choise){
                case 1:{


                }

                case 2:{
                    try {
                        sortIntegers("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task2\\data.txt", "C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task2\\out1.txt", "C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task2\\out2.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                        return;
                    }
                    System.out.println("Ready!");
                    break;
                }
                case 3:{
                    Student[] arr= new Student[3];
                    System.out.println("Enter name,Surname, speciality");
                    arr[0] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name,Surname, speciality");
                    arr[1] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name,Surname, speciality");
                    arr[2] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name of group");
                    AcademicGroup Group = new AcademicGroup(scanner.next(),arr);
                    try (XMLEncoder out = new XMLEncoder(new FileOutputStream("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task3\\Temp2.xml"))) {
                        out.writeObject(Group);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nдесеріалізація Temp2.xml");
                    DataDeserializable.XMLDeserializable("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task3\\Temp2.xml");

                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task3\\temp.dat"))) {
                        out.writeObject(Group);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nдесеріалізація Temp.dat");
                    DataDeserializable.DataDeserializable("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task3\\temp.dat");
                    break;
                }
                case 4:{
                    System.out.print("Уведіть ім\'я теки:");
                    scanner.nextLine();
                    String dirName = scanner.nextLine();

                    File dir = new File(dirName);
                    if (!dir.isDirectory()) {
                        System.out.println("Хибне ім\'я теки!");
                        return;
                    }
                    DirTree.list(dirName);
                    break;
                }
                case 5:{
                    Student[] arr= new Student[3];
                    System.out.println("Enter name,Surname, speciality");
                    arr[0] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name,Surname, speciality");
                    arr[1] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name,Surname, speciality");
                    arr[2] = new Student( scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Enter name of group");
                    AcademicGroup Group = new AcademicGroup(scanner.next(),arr);
                    ZipCreator.Create(Group,"Sourse.zip");
                    ZipCreator.Read("Sourse.zip");
                    break;
                }
                case 6:{

                   // SAXParser parser = null;
                    //try {
                      //  parser = SAXParserFactory.newInstance().newSAXParser();
                    //}
                    //catch (ParserConfigurationException | SAXException e) {
                     //   e.printStackTrace();
                    //}
                    if (0 > 1) {
                        InputSource input = new InputSource("Temp2.xml");


                     Dom.DomParser("C:\\Users\\Ivan\\IdeaProjects\\ЛАБ2ООП\\src\\Task6\\GroupFileWork.xml");

                        break;
                    }

                }
            }

        }while(choise!=0);
    }

}

