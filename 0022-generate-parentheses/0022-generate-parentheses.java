import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start with n open and n close brackets remaining
        solve(n, n, "", result);
        return result;
    }

    public void solve(int open, int close, String combination, List<String> result) {
        // Base Case: Both open and close brackets are exhausted
        if (open == 0 && close == 0) {
            result.add(combination);
            return;
        }

        // Option 1: Add an open bracket (if any remaining)
        if (open > 0) {
            solve(open - 1, close, combination + "(", result);
        }

        // Option 2: Add a close bracket (only if remaining close count > remaining open count)
        if (close > open) {
            solve(open, close - 1, combination + ")", result);
        }
    }
}