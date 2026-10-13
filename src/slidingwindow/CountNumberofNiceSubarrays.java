package slidingwindow;

import java.util.HashMap;

public class CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1)
                count++;

            int sum = count - k;

            ans += map.getOrDefault(sum, 0);
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return ans;
    }
}
