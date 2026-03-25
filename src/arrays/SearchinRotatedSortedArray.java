package arrays;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {

        // if(nums.length == 1) {
        // return nums[0] == target ? 0 : -1;
        // }
        // int l = 0;
        // int h = nums.length-1;

        // while(nums[l] > nums[h]) {
        // h-=1;
        // }

        // if(!(target >= nums[l] && target <= nums[h])) {
        // l = h+1;
        // h = nums.length-1;
        // }

        // while(l<=h) {
        // int mid = (l+h)/2;
        // if(nums[mid] == target) {
        // return mid;
        // }

        // if(target <= nums[mid]) {
        // h = mid -1;
        // } else {
        // l = mid+1;
        // }
        // }
        // return -1;

        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }

        return -1;

    }

}
