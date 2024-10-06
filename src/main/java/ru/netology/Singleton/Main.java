package main.java.ru.netology.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        Logger logger = Logger.getLogger();

        // приветсвие
        System.out.println();
        logger.log("Программа началась.");
        System.out.println("Привет! Введи два числа: " +
                "размер списка N и верхнюю границу M для значений в списке.");

        int n = 0;
        int m = 0;
        // получаем данные N
        while (true) {
            System.out.println("Введи размер списка N: ");
            n = sc.nextInt();
            if (n > 0) {
                logger.log("пользователь ввел размер списка N: " + n);
                break;
            } else {
                logger.log("пользователь ввел некоррктный размер списка N: " + n);
            }
        }
        // получаем данные M
        while (true) {
            System.out.println("Введи верхнюю границу M: ");
            m = sc.nextInt();
            if (m > 0) {
                logger.log("пользователь ввел верхнюю границу M: " + m);
                break;
            } else {
                logger.log("пользователь ввел некорректно верхнюю границу M: " + m);
            }
        }
        // cоздание списка из N элементов и заполнение случайными числами от 0 до M
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            randomList.add(rn.nextInt(m + 1)); // генерация случайного числа от 0 до M
        }
        int f = 0;
        // ввод числа f для фильтрации списка
        while (true) {
            System.out.println("Введите число f для фильтрации списка: ");
            f = sc.nextInt();
            if (f > 0) {
                logger.log("пользователь ввел число для фильтрации f: " + f);
                break;
            } else {
                logger.log("пользователь ввел некорре" +
                        "ктно число для фильтрации f: " + f);
            }
        }

        // создание объекта Filter с параметром f
        Filter filter = new Filter(f);
        logger.log("Создан объект Filter с порогом фильтрации f = " + f);

        // фильтрация списка
        List<Integer> filtredList = filter.filterOut(randomList);
        logger.log("Отфильтрованный список: " + filtredList);
        logger.log("Программа завершена.");
            }
}
