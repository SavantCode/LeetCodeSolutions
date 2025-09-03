class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row (horizontal flip) for clockwise rotation
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                // Swap matrix[i][start] with matrix[i][end]
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        /*
        // Uncomment the below code for anti-clockwise rotation (flip vertically)
        for (int col = 0; col < n; col++) {
            int top = 0;
            int bottom = n - 1;
            while (top < bottom) {
                int temp = matrix[top][col];
                matrix[top][col] = matrix[bottom][col];
                matrix[bottom][col] = temp;
                top++;
                bottom--;
            }
        }
        */
    }
}
