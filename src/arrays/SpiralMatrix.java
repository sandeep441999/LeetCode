package arrays;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, left = 0, right = cols - 1, bottom = rows - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println(ans);
        return ans;

    }
}
