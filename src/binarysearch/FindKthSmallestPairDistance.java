package binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        // List<Integer> list = new ArrayList<>();
        // for(int i=0;i<nums.length-1;i++) {
        // for(int j=i+1;j<nums.length; j++) {
        // list.add(Math.abs(nums[i]-nums[j]));
        // }
        // }
        // Collections.sort(list);
        Arrays.sort(nums);
        int l = 0, r = Integer.MIN_VALUE;
        for (int x : nums) {
            r = Math.max(r, x);
        }
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (countPairs(nums, mid) >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
        // return list.get(k-1);
    }

    public int countPairs(int[] nums, int diff) {
        int l = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > diff) {
                l++;
            }
            count += r - l;
        }
        return count;
    }
}
