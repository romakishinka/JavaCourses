package ru.java.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Lesson2 {
    public static void main(String[] args) throws IOException {

        int x = 1;                                                                 // первая задачка
        System.out.println(formula(x));


        String fullName = "Иванов Петр Александрович";                               // вторая задачка (вариант 1)
        System.out.println(initials(fullName));


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // вторая задачка (вариант 2)
        String fullName2 = reader.readLine();
        fullName2 = fullName2.toUpperCase();
        System.out.print(fullName2.charAt(0));
        System.out.print(".");
        for (int i = 1; i < fullName2.length(); i++) {
            if (fullName2.charAt(i-1) == ' ') {
                System.out.print(fullName2.charAt(i));
                System.out.print(".");
            }
            else
                continue;
        }


    }



    /**
         * Нужно реализовать формулу y = √(13x + 13/x)
         * Подсказка: квадратный корень вычисляется функцией Math.sqrt()
         *
         * @param x на текущем этапе входное значение будет больше нуля
         *
         * @return возвращаем только целую часть от полученного результата,
         * хвост отбрасываем без откругления
         */
        static int formula ( int x) {
            int y = (int) Math.sqrt((13*x)+(13/x) );
            return y;
        }

        /**
         * Нужно привести строку с полным именем к инициалам.
         * Например, "Иванов Петр Александрович" → "И.П.А."
         * Подсказка:
         * разделение строки на части: .split(" ");
         * получение символа на определенной позиции: .charAt();
         * приведение к верхнему регистру: .toUpperCase();
         *
         * @param fullName на текущем этапе имена будут состоять из имени, фамили и отчества, разделяться пробелами.
         *                 Регистр букв во входном параметре может быть любым.
         *
         * @return возвращаем инициалы в верхнем регистре разделенные точкой, как в примере выше
         */

        static String initials (String fullName){
            fullName = fullName.charAt(0) + "." + fullName.charAt(7) + "." + fullName.charAt(12) + "." ;
            return fullName;
        }


}
