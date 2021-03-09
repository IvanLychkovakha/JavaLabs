package Task4;

import java.util.Scanner;
public abstract class AbstractArrayOfPoints {
    // Запис нових координат точки:
    public abstract void setPoint(int i, double x, double y);

    // Отримання X точки i:
    public abstract double getX(int i);

    // Отримання Y точки i:
    public abstract double getY(int i);

    // Отримання кількості точок:
    public abstract int count();

    // Додавання точки в кінець масиву:
    public abstract void addPoint(double x, double y);

    // Видалення останньої точки:
    public abstract void removeLast();

    // Сортування за значеннями X:
    public void sortByX() {
        boolean mustSort; // Повторюємо доти,
        // доки mustSort дорівнює true
        do {
            mustSort = false;
            for (int i = 0; i < count()-1; i++) {
                if (getX(i) > getX(i + 1)) {
                    // обмінюємо елементи місцями
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true;
                }
            }
        }
        while (mustSort);
    }

    // Аналогічно можна реалізувати функцію sortByY()

    // Виведення точок у рядок:
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count(); i++) {
            s += "x = " + getX(i) + " \ty = " + getY(i) + "\n";
        }
        return s + "\n";
    }

    // Тестуємо сортування на чотирьох точках:
    public void test() {
        Scanner in = new Scanner(System.in);
        System.out.println("Тестовые значения");
        System.out.println("Введите количество точек");
        int all=in.nextInt();

        System.out.println("Введите х,y");
        for(int i=0;i<all;i++) {
            double x=in.nextDouble();
            double y=in.nextDouble();
            addPoint(x, y);
        }
        System.out.println(this);
        System.out.println("Удаление последнего елемента");
        removeLast();
        System.out.println(this);
        System.out.println("Сортировка по Х, по возростанию");
        sortByX();
        System.out.println(this);
    }

}