package binarysearch;

public class KthSmallestProductofTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return kthSmallestProduct(nums2, nums1, k);

        long a = (long) nums1[0] * nums2[0];
        long b = (long) nums1[0] * nums2[n - 1];
        long c = (long) nums1[m - 1] * nums2[0];
        long d = (long) nums1[m - 1] * nums2[n - 1];

        long l = Math.min(Math.min(a, b), Math.min(c, d));
        long r = Math.max(Math.max(a, b), Math.max(c, d));
        long ans = 0;

        while (l <= r) {
            long prod = l + (r - l) / 2;
            if (countProds(prod, m, n, nums1, nums2, k) >= k) {
                ans = prod;
                r = prod - 1;
            } else {
                l = prod + 1;
            }
        }

        return ans;
    }

    public long countProds(long prod, int m, int n, int[] nums1, int[] nums2, long k) {
        long res = 0;

        for (int x : nums1) {
            long count = 0;
            if (x == 0) {
                if (prod >= 0)
                    res += n;
                continue;
            } else if (x > 0) {
                int l = 0, r = n - 1;
                count = 0;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) x * nums2[mid] <= prod) {
                        count = (mid + 1);
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                res += count;
            } else {
                int l = 0, r = n - 1;
                int firstValid = n;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if ((long) x * nums2[mid] <= prod) {
                        firstValid = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                res += n - firstValid;
            }
        }
        return res;
    }
}
