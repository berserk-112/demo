package com.example.mapSetSortMethodTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSortTest {
    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(10,3);
        map.put(4, 9);
        map.put(30, 20);
        map.put(20, 15);
        map.put(2, 10);

        //sort by key
        System.out.println(map);//无序的，不一定是插入顺序
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.putAll(map);
        System.out.println("按key升序: " + treeMap);//正序
        TreeMap<Integer, Integer> treeMapDESC = new TreeMap<>((entry1, entry2) -> {
            return entry2 - entry1;
        });
        treeMapDESC.putAll(map);
        System.out.println("按key降序：" + treeMapDESC);

        //map to list
        Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted((entry1, entry2) -> {
            return entry1.getKey() - entry2.getKey();
        });
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        sorted.forEach((entry) -> {
            list.add(entry);
        });
        System.out.println(list);


        //sort by value
        List<Map.Entry<Integer, Integer>> listSortByValue = new ArrayList<>();
        map.entrySet().stream().sorted((entry1, entry2) -> {
            return entry1.getValue() - entry2.getValue();
        }).forEach((entry) -> listSortByValue.add(entry));
        System.out.println(listSortByValue);
    }
}
