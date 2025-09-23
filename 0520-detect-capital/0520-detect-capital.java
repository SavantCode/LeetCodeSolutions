// | Complexity Type                     | Value  |
// | ----------------------------------- | ------ |
// | Time Complexity                     | `O(n)` |
// | Space Complexity (with `charArray`) | `O(n)` |
// | Space Complexity (optimized)        | `O(1)` |


class Solution {
    public boolean detectCapitalUse(String word) {
        char[] charArray = word.toCharArray();
        boolean isAllUpper = true;
        boolean isAllLower = true;
        boolean isFirstUpperRestLower = true;

        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isUpperCase(charArray[i])) {
                isAllUpper = false;
            }
            if (!Character.isLowerCase(charArray[i])) {
                isAllLower = false;
            }
            if (i == 0) {
                if (!Character.isUpperCase(charArray[i])) {
                    isFirstUpperRestLower = false;
                }
            } else {
                if (!Character.isLowerCase(charArray[i])) {
                    isFirstUpperRestLower = false;
                }
            }
        }

        return isAllUpper || isAllLower || isFirstUpperRestLower;
    }
}
