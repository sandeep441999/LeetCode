package binarysearch;

public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid % 2 == 0) {
                if (mid == nums.length - 1)
                    return nums[mid];
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    ans = nums[mid];
                    r = mid - 1;
                }
            } else {
                if (mid == 0)
                    return nums[mid];
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    ans = nums[mid];
                    r = mid - 1;
                }
            }
        }

        return ans;
    }
}
