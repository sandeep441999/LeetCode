package binarysearch;

public class KthSmallestNumberinMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        int ans = 0;

        while (l <= r) {
            int prod = l + (r - l) / 2;
            if (countProd(m, n, prod) >= k) {
                ans = prod;
                r = prod - 1;
            } else {
                l = prod + 1;
            }
        }
        return ans;
    }

    public int countProd(int m, int n, int prod) {
        int res = 0;
        // for(int i=1; i<=m; i++) {
        // for(int j=1; j<=n; j++) {
        // if(i*j>prod) break;
        // res++;
        // }
        // }

        for (int j = 1; j <= m; j++) {
            res += Math.min(n, prod / j);
        }
        return res;
    }
}
