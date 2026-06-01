package arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1, post = 1;
        res[0] = prefix;

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = post * res[i];
            post = post * nums[i];
        }

        return res;
    }
}
