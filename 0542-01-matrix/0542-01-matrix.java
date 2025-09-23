// | Complexity Type      | Value      |
// | -------------------- | ---------- |
// | **Time Complexity**  | `O(m × n)` |
// | **Space Complexity** | `O(m × n)` |

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];

        // Initialize all elements to -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = -1;
            }
        }

        // Declaring a queue
        Queue<int[]> queue = new LinkedList<>();

        // Add all 0's to the queue and mark them as 0 in the result
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0; // Distance to nearest 0 is 0
                }
            }
        }

        // BFS directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                // If in bounds and not visited
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    result[newRow][newCol] == -1) {

                    result[newRow][newCol] = result[r][c] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return result;
    }
}
