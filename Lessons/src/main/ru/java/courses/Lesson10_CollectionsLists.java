package ru.java.courses;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson10_CollectionsLists{


    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Сортируем список по возрастанию
     * 4. Преобразуем числа в строки
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {
//        return source.stream().distinct().sorted().map(String::valueOf).collect(Collectors.toList());

        Collections.sort(source);
        List<String> res = new ArrayList<>();

        for (Integer i : source) {
            res.add(String.valueOf(i));
        }
        return res;

    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, list.get(i) + 1);
            }
        }

        ArrayList list2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (i >= 3 && i <= 7) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }


}
