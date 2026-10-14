class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        StringBuilder result = new StringBuilder();
        int digit = 0;

        if (sum > num * 9) return "";

        if (sum < 9) {
            result.append(sum);
            digit++;
        } else {
            int totalNines = sum / 9;

            for (int i = 0; i < totalNines; i++) {
                result.append("9");
                digit++;
            }

            int required = sum - (9 * totalNines);

            // Make sure you only append if required > 0 or as needed by your logic
            if (totalNines < num && required > 0) {
                result.append(required);
                digit++;
            }
        }

        // Use a while loop if you need to pad multiple zeros until the length matches `num`
        while (digit < num) {
            result.append("0");
            digit++;
        }

        return result.toString();
    }
}