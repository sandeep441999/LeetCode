package knapsack;

import java.util.Arrays;
import java.util.HashSet;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        int n = sum / 2;
        // Boolean[][] cache = new Boolean[nums.length][n+1];

        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            HashSet<Integer> next = new HashSet<>(dp);
            if (nums[i] == n)
                return true;
            for (int t : dp) {
                if (t + nums[i] == n)
                    return true;
                next.add(t + nums[i]);
            }
            dp = next;
        }

        return false;

        // return knapsack(nums, n, cache, 0, 0);

    }

    // public boolean knapsack(int[] nums, int n, Boolean[][] cache, int idx, int
    // sum) {
    // if(n==sum) return true;
    // if(sum > n || idx >= nums.length) return false;

    // if(cache[idx][sum] != null) return cache[idx][sum];
    // boolean pick = knapsack(nums, n, cache, idx+1, sum + nums[idx]);
    // boolean notPick = knapsack(nums, n, cache, idx+1, sum);

    // cache[idx][sum] = pick || notPick;
    // return cache[idx][sum];
    // }
}
