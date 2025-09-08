public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int id = 0;
        // id values:
        // 0 -> left to right
        // 1 -> top to bottom
        // 2 -> right to left
        // 3 -> bottom to top

        while (top <= down && left <= right) {
            if (id == 0) {
                // Left to right (Top row)
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (id == 1) {
                // Top to bottom (Right column)
                for (int i = top; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (id == 2) {
                // Right to left (Bottom row)
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            } else if (id == 3) {
                // Bottom to top (Left column)
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            id = (id + 1) % 4; // Rotate direction
        }

        return result;
    }
}