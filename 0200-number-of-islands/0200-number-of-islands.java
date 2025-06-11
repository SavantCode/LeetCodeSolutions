class Solution {
    
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1; // marks in visited array that this piece of island is being expolored
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    // Skip diagonals and self
                    if (Math.abs(delrow) + Math.abs(delcol) != 1) continue;

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && vis[row][col] == 0) {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }

        return count;
    }
}


/*




//---------------------------------JAVA------------
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    private List<int[]> dir = new ArrayList<>();
    
    Solution() {
        dir.add(new int[]{1, 0});
        dir.add(new int[]{-1, 0});
        dir.add(new int[]{0, 1});
        dir.add(new int[]{0, -1});
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        
        grid[i][j] = '$';
        
        for(int[] p : dir) {
            int i_ = i + p[0];
            int j_ = j + p[1];
            dfs(grid, i_, j_);
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}



//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean isSafe(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1';
    }
    
    private void bfs(char[][] grid, int i, int j, Queue<int[]> que) {
        que.offer(new int[]{i, j});
        grid[i][j] = '$';
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            
            for (int[] p : dir) {
                int i_ = curr[0] + p[0];
                int j_ = curr[1] + p[1];
                
                if (isSafe(grid, i_, j_)) {
                    que.offer(new int[]{i_, j_});
                    grid[i_][j_] = '$';
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> que = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, que);
                    count++;
                }
            }
        }
        
        return count;
    }
}


*/