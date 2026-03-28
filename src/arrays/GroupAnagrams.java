package arrays;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // for(String x : strs) {
        // char[] chars = x.toCharArray();
        // Arrays.sort(chars);

        // String key = new String(chars);

        // map.putIfAbsent(key, new ArrayList<>());

        // map.get(key).add(x);

        // }

        // return new ArrayList<>(map.values());

        for (String x : strs) {
            int[] arr = new int[26];
            for (Character c : x.toCharArray()) {
                arr[c - 'a'] += 1;
            }

            StringBuilder str = new StringBuilder();

            for (int i : arr) {
                str.append(i).append('#');
            }
            String key = str.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(x);
        }

        return new ArrayList<>(map.values());
    }

}
