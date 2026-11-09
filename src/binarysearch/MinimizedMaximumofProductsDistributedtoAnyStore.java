package binarysearch;

public class MinimizedMaximumofProductsDistributedtoAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 0, r = 0;
        for (int x : quantities) {
            r = Math.max(x, r);
        }
        int ans = r;
        while (l <= r) {
            int num = l + (r - l) / 2;
            if (canDo(n, quantities, num)) {
                ans = num;
                r = num - 1;
            } else {
                l = num + 1;
            }
        }
        return ans;
    }

    public boolean canDo(int n, int[] quantities, int num) {
        int count = 0;
        for (int x : quantities) {
            count += (int) Math.ceil((double) x / num);
            if (count > n)
                return false;
        }
        return true;
    }
}
