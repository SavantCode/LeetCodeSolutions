// | Complexity       | Value    |
// | ---------------- | -------- |
// | Time Complexity  | O(m × n) |
// | Space Complexity | O(m × n) |


class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // add rotten orange to queue
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Edge case: no fresh oranges
        if (freshCount == 0) return 0;

        // Step 2: BFS directions - up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        // Step 3: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0]; // r: Row index of orange
                int c = current[1]; // c: Column index of orange

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    // Check if neighbor is fresh
                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        // Rot it
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }

            // Only increment minutes if at least one orange rotted this round
            if (rottedThisMinute) {
                minutes++;
            }
        }

        // Step 4: Check if any fresh oranges left
        return freshCount == 0 ? minutes : -1;
    }
}
