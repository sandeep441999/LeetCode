package arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = (nums.length * (nums.length + 1)) / 2;

        for (int x : nums) {
            n -= x;
        }

        return n;
    }

}
