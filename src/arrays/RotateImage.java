package arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < rows; i++) {
            int k = rows - 1;
            ;
            for (int j = 0; j < cols; j++) {
                if (k <= j) {
                    break;
                }

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                k -= 1;
            }
        }
    }

}
