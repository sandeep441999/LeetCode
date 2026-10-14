package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int prefixSum = 0, ans = 0;

        for (int r = 0; r < nums.length; r++) {
            prefixSum += nums[r];

            int rem = prefixSum % k;

            if (rem < 0) {
                rem += k;
            }

            ans += map.getOrDefault(rem, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}
