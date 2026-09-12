class Solution {

    // Stores the row and column of a cell
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        // Queue is used for BFS traversal
        Queue<Pair> queue = new LinkedList<>();

        // Store the color of the starting cell.
        // We only want to change cells having this color.
        int originalColor = image[sr][sc];

        // 4 possible directions:
        // right, left, down, up
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        // If the starting color is already the target color,
        // nothing needs to be changed.
        // Also prevents unnecessary BFS processing.
        if (originalColor == color) {
            return image;
        }

        // Change the starting cell to the new color.
        // This also marks it as visited.
        image[sr][sc] = color;

        // Start BFS from the source cell
        solve(
            queue,
            sr,
            sc,
            image,
            directions,
            color,
            originalColor,
            rows,
            cols
        );

        return image;
    }

    public void solve(
        Queue<Pair> queue,
        int i,
        int j,
        int[][] image,
        int[][] directions,
        int color,
        int originalColor,
        int rows,
        int cols
    ) {

        // Add the starting cell to the BFS queue
        queue.add(new Pair(i, j));

        // Continue until there are no more cells to process
        while (!queue.isEmpty()) {

            // Remove the front cell from the queue
            Pair current = queue.poll();

            int currRow = current.i;
            int currCol = current.j;

            // Try all 4 neighboring cells
            for (int[] dir : directions) {

                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                /*
                 * A neighboring cell can be added to BFS only if:
                 *
                 * 1. It is inside the matrix
                 * 2. Its color is the original color
                 *
                 * We don't need a separate visited array because
                 * changing its color also marks it as visited.
                 */
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == originalColor) {

                    // Change color immediately.
                    // This prevents the same cell from being
                    // added to the queue multiple times.
                    image[newRow][newCol] = color;

                    // Add this cell to BFS for further exploration
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}

// Start cell
//     ↓
// Put in queue
//     ↓
// Take cell from queue
//     ↓
// Check 4 neighbours
//     ↓
// Is neighbour inside grid?
//     ↓
// Does neighbour have original color?
//     ↓
// Change its color + put in queue
//     ↓
// Repeat
