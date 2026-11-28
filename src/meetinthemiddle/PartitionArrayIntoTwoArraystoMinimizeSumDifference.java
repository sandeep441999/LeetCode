package meetinthemiddle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {
    public int minimumDifference(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int n = nums.length / 2;

        int[] a = Arrays.copyOfRange(nums, 0, n);
        int[] b = Arrays.copyOfRange(nums, n, 2 * n);

        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        generate(n - 1, 0, 0, a, left);
        generate(n - 1, 0, 0, b, right);

        for (List<Integer> l : right) {
            Collections.sort(l);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            List<Integer> lList = left.get(i);
            List<Integer> rList = right.get(n - i);

            for (int x : lList) {
                double target = total / 2.0 - x;

                int idx = lowerBound(target, rList);

                if (idx < rList.size()) {
                    int s1 = x + rList.get(idx);
                    res = Math.min(res, Math.abs(total - 2 * s1));
                }

                if (idx > 0) {
                    int s1 = x + rList.get(idx - 1);
                    res = Math.min(res, Math.abs(total - 2 * s1));
                }

                if (res == 0)
                    return res;
            }
        }

        return res;
    }

    public int lowerBound(double target, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public void generate(int i, int cur, int len, int[] nums, List<List<Integer>> dp) {

        if (i < 0) {
            dp.get(len).add(cur);
            return;
        }

        generate(i - 1, cur + nums[i], len + 1, nums, dp);
        generate(i - 1, cur, len, nums, dp);
    }
}
