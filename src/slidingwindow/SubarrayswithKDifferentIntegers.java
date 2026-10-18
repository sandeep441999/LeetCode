package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
