package arrays;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        // int minAns = 5001;

        while (l < h) {
            int mid = (l + h) / 2;
            // minAns = Math.min(minAns, nums[mid]);

            // if(nums[mid] > nums[h] && nums[h] < nums[l]) {
            // l = mid+1;
            // } else {
            // h = mid-1;
            // }

            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }
}
