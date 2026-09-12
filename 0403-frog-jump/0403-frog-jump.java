// Approach-1: Recursion + Memoization
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {

    // Maps: stone position -> its index in the stones array
    // Example: stones = [0, 1, 3, 5]
    // mp = {0=0, 1=1, 3=2, 5=3}
    //
    // This allows us to quickly check whether a stone exists at
    // a particular position and get its index in O(1) average time.
    HashMap<Integer, Integer> mp = new HashMap<>();


    // DP table for memoization.
    //
    // t[curr_stone_index][prevJump] stores:
    //
    // -1 -> state has NOT been calculated yet
    //  0 -> cannot reach the last stone from this state
    //  1 -> can reach the last stone from this state
    //
    // State = (current stone, previous jump)
    int t[][] = new int[2001][2001];


    // Number of stones
    int n;


    /*
     * Returns true if the frog can reach the last stone
     * starting from curr_stone_index, when its previous jump
     * was prevJump.
     *
     * State:
     *     (curr_stone_index, prevJump)
     *
     * From previous jump = k, the next jump can be:
     *     k - 1
     *     k
     *     k + 1
     */
    boolean solve(int[] stones, int curr_stone_index, int prevJump) {

        // BASE CASE:
        // If we're standing on the last stone,
        // we've successfully crossed the river.
        if(curr_stone_index == n - 1)
            return true;


        // result will become true if ANY of the possible
        // next jumps can eventually reach the last stone.
        boolean result = false;


        // MEMOIZATION:
        // If this state has already been calculated,
        // return the stored result instead of recalculating it.
        //
        // This prevents repeated recursive work.
        if(t[curr_stone_index][prevJump] != -1)
            return t[curr_stone_index][prevJump] == 1;


        /*
         * If previous jump was 'k', then the next jump
         * can be:
         *
         *     k - 1
         *     k
         *     k + 1
         *
         * So we try all 3 possibilities.
         */
        for(int nextJump = prevJump - 1;
            nextJump <= prevJump + 1;
            nextJump++) {


            // Jump length must always be positive.
            //
            // This is especially important for the first jump:
            // prevJump = 0
            // possible next jumps = -1, 0, 1
            // Only 1 is valid.
            if(nextJump > 0) {

                // Calculate the position where the frog
                // would land after making nextJump.
                int next_stone =
                    stones[curr_stone_index] + nextJump;


                // Check whether there is actually a stone
                // at this position.
                //
                // HashMap lets us check this in O(1) average time.
                if(mp.containsKey(next_stone)) {

                    /*
                     * If a stone exists at next_stone,
                     * recursively check whether we can reach
                     * the final stone from there.
                     *
                     * mp.get(next_stone) gives the index
                     * of the next stone.
                     *
                     * We pass nextJump as prevJump because
                     * this jump becomes the previous jump
                     * for the next recursive call.
                     */
                    result = result ||
                             solve(
                                 stones,
                                 mp.get(next_stone),
                                 nextJump
                             );
                }
            }
        }


        /*
         * Store the result of this state.
         *
         * true  -> 1
         * false -> 0
         *
         * Next time we encounter the same
         * (curr_stone_index, prevJump) state,
         * we can directly return this value.
         */
        t[curr_stone_index][prevJump] = (result ? 1 : 0);


        return result;
    }


    public boolean canCross(int[] stones) {

        // Store number of stones.
        n = stones.length;


        /*
         * The first jump MUST be exactly 1.
         *
         * Since frog starts at stones[0],
         * stones[1] must be at position 1.
         *
         * Example:
         * [0, 1, 3, 5] -> possible
         * [0, 2, 3, 5] -> impossible
         */
        if(stones[1] != 1)
            return false;


        /*
         * Build HashMap:
         *
         * stone position -> index
         *
         * This is needed because during recursion
         * we calculate a POSITION, but solve() needs
         * the INDEX of that stone.
         */
        for (int i = 0; i < stones.length; i++) {
            mp.put(stones[i], i);
        }


        /*
         * Java initializes int arrays with 0.
         *
         * But we need 3 states in our DP:
         *
         * -1 -> not calculated
         *  0 -> calculated, cannot reach
         *  1 -> calculated, can reach
         *
         * Therefore initialize the entire DP table with -1.
         */
        for (int i = 0; i < 2000; i++) {
            Arrays.fill(t[i], -1);
        }


        /*
         * Start recursion from:
         *
         * stone index = 0
         * previous jump = 0
         *
         * From prevJump = 0, possible next jumps are:
         *     -1, 0, 1
         *
         * Only 1 is positive, so the first jump
         * automatically becomes 1.
         */
        return solve(stones, 0, 0);
    }
}
