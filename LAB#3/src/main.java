import java.util.*;

import  Task2.*;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choise;
        do {
            System.out.println("Введите номер задания(2,3,6)\n");
            choise = scanner.nextInt();

            switch (choise) {
                case 2:{
                    Month d = Month.Грудень;
                    System.out.println(d+" кількість днів "+ d.getDay());
                    System.out.println("Тест на принадлежність даного місяця до певного сезону");
                    System.out.println(d+" "+d.Season());
                    System.out.println("Виведемо наступний місяць");
                    System.out.println(d.next());
                    System.out.println("Виведемо минулий місяць");
                    System.out.println(d.last());
                    System.out.println("Виведемо всі місяці та їхню кількість днів");
                    d.soutAll();
                    break;
                }
                case 3:{
                    Map<String, String> users = new HashMap<String, String>();
                    users.put(scanner.next(), scanner.next());
                    for(int i =0; i<3; i++){
                        String key = scanner.next();
                        String value = scanner.next();
                            if (users.keySet().contains(key))
                              //  users.put(key+"q", value);
                                System.out.println("Этот пользователь уже зарегистрирован");
                            else
                                users.put(key, value);
                    }
                    System.out.println("користувачі з паролем довшим 6 знаків: ");
                    for (Map.Entry<String, String> entry : users.entrySet()) {
                        if (entry.getValue().length() > 6)
                            System.out.println("Ім*я: " + entry.getKey() + " Пароль: " + entry.getValue());
                    }
                    break;
                }
                case 6:{
                    // Функція nextLine() читає рядок до кінця:
                    scanner.nextLine();
                    String sentence = scanner.nextLine();
                    String[] words = sentence.split("[,;:.!?\\s]+");
                    TreeSet<String> ts = new TreeSet<String>(new Comparator<String>()
                    {
                        @Override
                        public int compare(String s1, String s2) {
                            return s1.compareTo(s2);
                        }

                    });
                        for(String subStr:words){
                            ts.add(subStr);
                        }
                    for (String element : ts)
                        System.out.print(element + " ");
                    break;
                }
            }
        } while (choise != 0);
    }
}