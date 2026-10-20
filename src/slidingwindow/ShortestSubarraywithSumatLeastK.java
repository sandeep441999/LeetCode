package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int min = n + 1;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> q = new ArrayDeque<>();

        while (r <= n) {

            while (!q.isEmpty() && prefix[r] - prefix[q.peekFirst()] >= k) {
                min = Math.min(min, r - q.pollFirst());
            }

            while (!q.isEmpty() && prefix[r] <= prefix[q.peekLast()]) {
                q.pollLast();
            }

            q.offerLast(r);
            r++;
        }
        return min == n + 1 ? -1 : min;
    }
}
