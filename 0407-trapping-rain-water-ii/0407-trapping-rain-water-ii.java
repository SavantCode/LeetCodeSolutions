import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all border cells to the min heap and mark them as visited
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int[] dir : directions) {
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    int water = Math.max(0, cell.height - heightMap[x][y]);
                    totalWater += water;
                    minHeap.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
                }
            }
        }

        return totalWater;
    }

    class Cell {
        int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
