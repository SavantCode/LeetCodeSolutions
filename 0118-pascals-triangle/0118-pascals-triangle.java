import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) return triangle;

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1); // First element of each row is 1

            for (int j = 1; j < i; j++) {
                // Add sum of two elements from the previous row
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // Last element of each row is 1
            triangle.add(row);
        }

        return triangle;
    }

    // Optional: for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int numRows = 5;
        List<List<Integer>> result = sol.generate(numRows);

        // Print result
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
