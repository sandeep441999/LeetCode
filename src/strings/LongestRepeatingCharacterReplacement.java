package strings;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // Map<Character, Integer> map = new HashMap<>();
        // int ans = 1;
        // int i=0,j=0;

        // while(j<s.length()) {
        // if(!map.containsKey(s.charAt(j))) {
        // map.put(s.charAt(j), 1);
        // } else {
        // map.put(s.charAt(j), map.get(s.charAt(j))+1);
        // }
        // int cmax = getCMax(map);
        // if(((j-i + 1) - cmax) <= k) {
        // ans = Math.max(ans, j-i+1);
        // } else {
        // while(((j-i + 1) - cmax) > k) {
        // map.put(s.charAt(i), map.get(s.charAt(i))-1);
        // i+=1;
        // cmax = getCMax(map);
        // }
        // }
        // j+=1;
        // }
        // return ans;

        int[] count = new int[26];
        int l = 0, cmax = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            cmax = Math.max(cmax, count[s.charAt(r) - 'A']);

            if ((r - l + 1) - cmax > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);

        }
        return ans;
    }

    public int getCMax(Map<Character, Integer> map) {
        int cmax = 0;
        for (Integer x : map.values()) {
            cmax = Math.max(cmax, x);
        }
        return cmax;
    }

}
