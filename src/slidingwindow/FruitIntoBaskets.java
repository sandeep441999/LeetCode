package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        // int n=fruits.length, l=0, r=0, len = 0, maxi=Integer.MIN_VALUE;
        int n = fruits.length, l = 0, maxi = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // while(r<n) {
        // int key = fruits[r];
        // if(map.containsKey(key)) {
        // map.put(key, map.get(key)+1);
        // len = r-l+1;
        // } else {
        // while(map.size() >= 2) {
        // map.put(fruits[l], map.get(fruits[l])-1);
        // if(map.get(fruits[l]) == 0) {
        // map.remove(fruits[l]);
        // }
        // l++;
        // }

        // map.put(key, map.getOrDefault(key, 1));
        // len = r-l+1;
        // }
        // maxi = Math.max(maxi, len);
        // r++;
        // }

        for (int r = 0; r < n; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxi = Math.max(maxi, r - l + 1);
        }

        return maxi;
    }
}
