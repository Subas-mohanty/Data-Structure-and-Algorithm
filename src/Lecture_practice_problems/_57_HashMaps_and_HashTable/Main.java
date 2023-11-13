package Lecture_practice_problems._57_HashMaps_and_HashTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("subas", 87);
        map.put("manas", 98);
        map.put("arpit", 89);
        map.put("rahul", 85);
        System.out.println(map); // its internally calling map.toString
        // System.out.println(map.get("subas"));
        // System.out.println(map.getOrDefault( "Apoorv", 78));
        System.out.println(map.containsKey("Karan"));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);
        set.add(2);

        System.out.println(set);
    }
}
