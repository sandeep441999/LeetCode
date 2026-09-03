package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // HashSet<Character> set = new HashSet<>();
        // int[] freq = new int[26];

        // for(char c : s.toCharArray()) {
        // freq[c - 'a']++;
        // }

        // boolean found = false;
        // int cur = 0;

        // for(int i=0; i<s.length(); i++) {
        // cur++;
        // char c = s.charAt(i);
        // int idx = c - 'a';
        // set.add(c);
        // freq[idx]--;
        // if(freq[idx] == 0) {
        // if(set.size() > 1) {
        // boolean all = true;
        // for(char x : set) {
        // if(freq[x - 'a'] != 0) {
        // all = false;
        // }
        // }
        // if(all) {
        // found = true;
        // set.clear();
        // }
        // } else {
        // found = true;
        // set.clear();
        // }
        // }

        // if(found) {
        // res.add(cur);
        // found = false;
        // cur=0;
        // }
        // }

        // return res;

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int size = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            size++;

            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
