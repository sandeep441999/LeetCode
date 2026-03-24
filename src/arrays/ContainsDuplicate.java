package arrays;

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++) {
        // if(map.containsKey(nums[i])) {
        // return true;
        // } else {
        // map.put(nums[i], 1);
        // }
        // }
        // return false;

        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}