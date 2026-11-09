package binarysearch;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int r = matrix[n - 1][n - 1], l = matrix[0][0];
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int count = 0;

            for (int[] row : matrix) {
                count += getCount(row, mid);
            }

            if (count >= k) {
                ans = mid;

                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int getCount(int[] row, int value) {
        int l = 0, r = row.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (row[mid] <= value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
