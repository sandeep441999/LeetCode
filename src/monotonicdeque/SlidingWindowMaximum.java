package monotonicdeque;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int i=0, j=k;
        int n = nums.length;
        int[] res = new int[n - k + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        // int idx = 0;
        // int cur = Integer.MIN_VALUE;
        // while(idx < k) {
        // // q.offer(nums[idx]);
        // cur=Math.max(cur, nums[idx]);
        // idx++;
        // }
        // idx=0;
        // res[idx] = cur;
        // idx++;

        // while(j<n) {
        // i++;
        // if(nums[i-1] == cur) {
        // cur = Integer.MIN_VALUE;
        // for(int x = i; x<=j; x++) {
        // cur = Math.max(cur, nums[x]);
        // }
        // } else {
        // cur = Math.max(cur, nums[j]);
        // }
        // res[idx] = cur;
        // idx++;
        // j++;
        // }
        // return res;

        int l = 0, r = 0, idx = 0;

        while (r < n) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[r]) {
                q.pollLast();
            }

            while (!q.isEmpty() && l > q.peek()) {
                q.poll();
            }

            q.offer(r);

            if (r + 1 >= k) {
                res[idx++] = nums[q.peek()];
                l++;
            }
            r++;
        }

        return res;

    }
}
