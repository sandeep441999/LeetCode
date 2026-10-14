package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0)
                count--;
            else
                count++;

            if (map.containsKey(count)) {
                ans = Math.max(ans, r - map.get(count));
            } else {
                map.put(count, r);
            }
        }

        return ans;
    }
}
