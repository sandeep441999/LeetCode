package topologicalsort;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());
            if ((s1.length() > s2.length()) &&
                    (s1.substring(0, len).equals(s2.substring(0, len))))
                return "";

            for (int j = 0; j < len; j++) {
                char u = s1.charAt(j);
                char v = s2.charAt(j);
                if (u != v) {
                    if (adj.get(u).add(v)) {
                        indegree.put(v, indegree.get(v) + 1);
                    }
                    break;
                }
            }
        }

        ArrayDeque<Character> q = new ArrayDeque<>();

        for (Character k : indegree.keySet()) {
            if (indegree.get(k) == 0) {
                q.offer(k);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);

            for (Character val : adj.get(c)) {
                indegree.put(val, indegree.get(val) - 1);
                if (indegree.get(val) == 0)
                    q.offer(val);
            }
        }

        if (sb.length() < indegree.size())
            return "";
        return sb.toString();
    }
}
