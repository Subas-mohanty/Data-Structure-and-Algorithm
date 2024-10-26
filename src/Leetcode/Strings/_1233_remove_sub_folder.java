package Leetcode.Strings;

import java.util.*;
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/?envType=daily-question&envId=2024-10-25

public class _1233_remove_sub_folder {

    public static void main(String[] args) {
        String[] folder = {"/bo/cp/cu/cw", "/dc/dd/de/dg", "/bo/bp/bu/bw", "/bo/cp/cu", "/dc/dd/di", "/dc/dd/di/dk", "/dc/dd/dm/dp", "/dc/ed/ee/eh", "/dc/ed/ei/ek", "/bo/cc/cl/co", "/bo/cc/cl", "/aa/ao/ax/az", "/dc/dd/di/dl", "/dc/dq/dr", "/aa/ab", "/aa/bb/bg/bj", "/dc/dq/dr/dt", "/dc/dd/dm", "/dc/dq/dr/du", "/dc/dd/de/dh"};
        System.out.println(removeSubfolders(folder));
    }

    // TC : O(n * k)
    // SC : O(n) + O(k) --> set + auxiliary space
    public static List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (String s : folder) {
            boolean flag = false;
            String sub = s;
            // for each string checking if any of its prefix ending at '/' is present in the set or not, if present then there is a parent folder of this folder is present so it is a sub folder and we don't add it into the answer list
            for (int i = sub.length() - 1; i >= 0; i--) {
                if (sub.charAt(i) == '/') {
                    sub = sub.substring(0, i);
                    if (set.contains(sub)) flag = true;
                }
            }
            if (!flag) list.add(s);
            set.add(s);
        }
        return list;
    }


    // TC : O(n * k)
    // SC : O(n)
    public List<String> removeSubfolders2(String[] folder) {
        Set<String> set = new HashSet<>();
        Arrays.sort(folder);

        // Learning
        outer:
        for (String s : folder) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '/') {
                    String sub = s.substring(0, i);
                    if (set.contains(sub)) continue outer; // it will continue the outer loop
                }
            }
            set.add(s);
        }
        return new ArrayList<>(set);
    }
}
