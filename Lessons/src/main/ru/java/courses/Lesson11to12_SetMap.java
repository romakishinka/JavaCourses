package ru.java.courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.swing.tree.TreeCellEditor;

public class Lesson11to12_SetMap {

    public static class User {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {
        Comparator<User> comparator = new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName())  | (Integer.compare(o1.getAge(), o2.getAge()));
            }
        };
        ArrayList<User> list = new ArrayList(source);
        Collections.sort(list, comparator);
        return list.get(list.size()-1);
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {
        HashMap<String, User> map = new HashMap<>();
        ArrayList<User> list = new ArrayList(source);
        int count = 0;

        for (User user : list) {
            map.put(user.getPhone(), user);
        }

        for(Map.Entry<String, User> pair : map.entrySet()) {
            count++;
        }
        return count;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {
        TreeSet<String> set = new TreeSet<>(source);
        ArrayList list = new ArrayList(set);

        HashMap<Integer, List<String>> map = new HashMap<>();
        int part = 0;
        int interval =list.size()/5;

        map.put(1, new ArrayList<>(list.subList(0, part+=interval)));
        map.put(2, new ArrayList<>(list.subList(part, part+=interval)));
        map.put(3, new ArrayList<>((list.subList(part, part+=interval))));
        map.put(4, new ArrayList<>(list.subList(part, part+=interval)));
        map.put(5, new ArrayList<>(list.subList(part,list.size())));


        return map;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        Map <String, Integer> map = new HashMap<>();

        for (Map.Entry<Integer, String> pair : source.entrySet()) {
            map.put(pair.getValue(), pair.getKey());
        }
        return map;

    }
}
