package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        // Добавление элементов в список
        list.add(0,1);
        list.add(1, 2);
        list.add(2, 3);

        // Получение элемента по индексу
        System.out.println(list.get(0)); // Output: 3

        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(4);
        anotherList.add(5);
        list.addAll(anotherList);
        System.out.println(list.get(3)); // Output: 4

        list.remove(1);
        System.out.println(list.get(1)); // Output: 2

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0)); // Output: 2
    }
}

