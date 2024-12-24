package Lecture_practice_problems_kunal_kushwaha._57_HashMaps_and_HashTable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("subas", 87);
//        map.put("manas", 98);
//        map.put("arpit", 89);
//        map.put("rahul", 85);
//        System.out.println(map); // its internally calling map.toString
//        // System.out.println(map.get("subas"));
//        // System.out.println(map.getOrDefault( "Apoorv", 78));
//        System.out.println(map.containsKey("Karan"));
//
//        HashSet<Integer> set = new HashSet<>();
//        set.add(56);
//        set.add(9);
//        set.add(12);
//        set.add(43);
//        set.add(56);
//        set.add(2);
//
//        System.out.println(set);

//        HashUsingMap map = new HashUsingMap();
//        map.put("subas", 89);
//        map.put("raghu", 99);
//        map.put("raman", 96);
////        System.out.println(map.get("subas"));
////        System.out.println(map.remove("raghu"));
////        System.out.println(map.get("raghu"));
//        x<String,Integer> man = new x<>();
//        man.put("subas", 89);
//        System.out.println(man.get("subas"));
//        System.out.println(man.remove("subas"));

        HashMapGenerics<String, Integer> map = new HashMapGenerics<>();
        map.put("subas",2);
        map.put("subu",3);
        map.put("raghu",5);
        System.out.println(map);
        System.out.println(map.containKey("subas"));
    }
}
