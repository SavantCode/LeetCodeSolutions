
//Approach-3 (Optimized Bottom UP DP)
/*
    If you notice, you are just requiring the previous row's value
    See the if condition    - dp[i-1][j-1] + dp[i-1][j]; //(i-1) points to previous row
    
    See the else condition  - dp[i-1][j]; //(i-1) points to previous row
    
    So, why not simply store previous value in a 1-D array
    We can then solve this qn, using O(m+n) space complexity
*/
//T.C : O(m*n)
//S.C : O(m + n)
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[] curr = new long[n+1];
        long[] prev = new long[n+1];
        
        prev[0] = curr[0] = 1;
        
        for(int i = 1; i<m+1; i++) {
            
            for(int j = 1; j<n+1; j++) {
                
                if(s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = prev[j-1] + prev[j];
                else
                    curr[j] = prev[j];
            }
            prev = curr.clone();
        }
        return (int) prev[n];
    }
}