//Approach - Using Multi-Source BFS
//T.C : O(m * n) , We will visit all cells once
//S.C : O(m * n), in worst case queue will contain all the cells
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Add all rotten oranges to the queue
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0; // No fresh oranges to rot
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Mark as rotten
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }
            time++;
        }

        return freshCount == 0 ? time - 1 : -1;
    }
}