package binarysearch;

public class FindaPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0, h = mat[0].length - 1;
        while (l <= h) {
            int midCol = l + (h - l) / 2;

            int maxRow = 0;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            boolean leftPeak = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightPeak = midCol < mat[0].length - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (!leftPeak && !rightPeak)
                return new int[] { maxRow, midCol };
            else if (leftPeak)
                h = midCol - 1;
            else
                l = midCol + 1;
        }

        return new int[] { -1, -1 };
    }
}
