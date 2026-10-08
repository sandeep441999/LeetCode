package twopointers;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        int j = nums.length - 1;
        int i = j - 1;

        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i < 0) {
            reverse(nums, 0);
            return;
        }

        int k = nums.length - 1;
        while (nums[k] <= nums[i]) {
            k--;
        }
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
        reverse(nums, i + 1);
        return;
    }

    public void reverse(int[] nums, int ind) {
        int l = ind, r = nums.length - 1;
        while (l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        return;
    }
}
