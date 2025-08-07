//Approach-2 - (Bottom Up)
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] t = new int[n][n];
        // t[i][j] = max fruits collected till [i][j]

        // child1Collect - Diagonal elements
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fruits[i][i];
        }

        // Before child2 and child3, nullify the cells which can't be visited by child2 and child3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && i + j < n - 1) {
                    t[i][j] = 0;
                } else if (i > j && i + j < n - 1) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = fruits[i][j];
                }
            }
        }

        // child2 collect fruits
        // cells upper to diagonal : i < j
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                t[i][j] += Math.max(t[i - 1][j - 1], Math.max(t[i - 1][j], (j + 1 < n) ? t[i - 1][j + 1] : 0));
            }
        }

        // child3 collect fruits
        // cells below diagonal : i > j
        for (int j = 1; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                t[i][j] += Math.max(t[i - 1][j - 1], Math.max(t[i][j - 1], (i + 1 < n) ? t[i + 1][j - 1] : 0));
            }
        }

        return result + t[n - 2][n - 1] + t[n - 1][n - 2];
    }
}