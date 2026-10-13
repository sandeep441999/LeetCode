package slidingwindow;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int r = 0, n = nums.length, sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        while (r < n) {
            sum += nums[r];

            count += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            r++;
        }

        return count;
    }
}
