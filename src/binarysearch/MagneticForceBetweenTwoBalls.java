package binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1;
        int r = position[n - 1] - position[0];
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canDo(position, m, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public boolean canDo(int[] position, int m, int force) {
        int prev = 0, count = 1;
        for (int i = 1; i < position.length; i++) {
            int diff = Math.abs(position[i] - position[prev]);

            if (diff >= force) {
                count++;
                prev = i;
            }
        }

        return count >= m;
    }
}
