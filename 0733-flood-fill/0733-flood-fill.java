class Solution {

    public class Pair {

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

        Queue<Pair> queue = new LinkedList<>();

        int originalColor = image[sr][sc];

        int directions[][] = {
            {0, 1},
            {0, -1},
            {1, 0}, 
            {-1, 0}
        }; // right, left, down, up

        // Important: If the original color is already the target color,
        // we can return immediately. Otherwise BFS can keep processing
        // unnecessarily.
        if (originalColor == color) {
            return image;
        }

        image[sr][sc] = color;

        solve(queue, sr, sc, image, directions, color, originalColor, rows, cols);

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

        // Mistake: queue is Queue<int[]>, but you were trying to add Pair.
        // Also Pair(i, j) must use the 'new' keyword.
        queue.add(new Pair(i, j));

        while (!queue.isEmpty()) {

            Pair top = queue.poll();

            int currRow = top.i;
            int currCol = top.j;

            for (int[] dir : directions) {

                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                // Mistake: isSafe() was not defined.
                // We check that the new position is inside the matrix.
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == originalColor) {

                    // Mark as visited by changing its color.
                    image[newRow][newCol] = color;

                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}