package arrays;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int pe = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (pe > intervals[i][0]) {
                ans += 1;
                pe = pe > intervals[i][1] ? intervals[i][1] : pe;
            } else {
                pe = intervals[i][1];
            }
        }
        return ans;
    }
}
