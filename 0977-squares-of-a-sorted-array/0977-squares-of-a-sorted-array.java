class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];


        for(int i = 0; i < n; i++ ){
            int val = nums[i];
            squares[i] = (val*val);
        }
        Arrays.sort(squares);
        return squares;
    }
}