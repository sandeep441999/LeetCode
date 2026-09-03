package heap;

import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    PriorityQueue<Integer> q;
    int k;
    int[] nums;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;
        this.nums = nums;

        for (int i = 0; i < nums.length; i++) {
            this.q.offer(nums[i]);
        }

        while (this.q.size() > k) {
            this.q.poll();
        }
    }

    public int add(int val) {
        q.offer(val);
        while (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
