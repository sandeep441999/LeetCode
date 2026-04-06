package arrays;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int x : nums) {
            set.add(x);
        }

        for (int y : set) {
            if (!set.contains(y - 1)) {
                int curr = y;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr += 1;
                    count += 1;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
