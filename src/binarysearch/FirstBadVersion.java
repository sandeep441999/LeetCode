package binarysearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n, start = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isBadVersion(mid)) {
                start = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBadVersion'");
    }
}
