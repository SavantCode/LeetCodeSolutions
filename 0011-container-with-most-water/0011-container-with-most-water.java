//O(n), avoiding TLE.
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int currWidth = right - left;
            int currArea = currHeight * currWidth;
            maxArea = Math.max(maxArea, currArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}




//-------------------Getting  TLE  for this -- O(n²)
// import java.util.Arrays;

// class Solution {
//     public int maxArea(int[] height) {
        
//         int area = Integer.MIN_VALUE;
//         int n = height.length;
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 int currHeight =Math.min(height[i], height[j]);

//                 int currWidth = Math.abs(j - i);
//                 int currArea = currHeight * currWidth;
//                 area = Math.max(currArea, area);
//             }
//         }
//         return area;
//     }
// }
