package org.example.HomeWork1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("1. Добавление элементов:");
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);

        System.out.println(map.toString());

    }
}
