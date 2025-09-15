//T.C : O(nlogn) 
//S.C : O(1)

public class Solution {

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens); // Sort tokens in ascending order to make greedy decisions

        int currScore = 0;  // Current score after playing some tokens
        int maxScore = 0;   // Keep track of the maximum score achieved
        int l = 0;          // Left pointer - used to buy score with the smallest token
        int r = tokens.length - 1; // Right pointer - used to regain power with the largest token

        // Greedy approach:
        // Use smallest token to gain score when possible
        // If not enough power, use one score to gain back power from largest token
        while (l <= r) {
            if (P >= tokens[l]) {
                // Sufficient power to play token face up (gain 1 score)
                P -= tokens[l];
                currScore++;
                maxScore = Math.max(maxScore, currScore);
                l++;
            } else if (currScore >= 1) {
                // Not enough power, but we can trade 1 score to regain power by playing token face down
                P += tokens[r];
                currScore--;
                r--;
            } else {
                // Neither enough power nor score to make a move
                break;
            }
        }

        return maxScore;
    }
}
