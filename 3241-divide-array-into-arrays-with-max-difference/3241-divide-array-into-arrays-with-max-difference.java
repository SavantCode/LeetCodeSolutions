class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to group close values --> O(n log n)
        int n = nums.length;

        // If we can't divide into groups of 3, return empty array
        if (n % 3 != 0) {
            return new int[0][];
        }

        int[][] result = new int[n / 3][3]; // Prepare result array
        int index = 0;

        for (int i = 0; i < n; i += 3) { // O(n)
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Since sorted, max - min = c - a
            if (c - a > k) {
                return new int[0][]; // prints: [] not [ [] ]
            }

            result[index][0] = a;
            result[index][1] = b;
            result[index][2] = c;
            index++;
        }

        return result;// We're returning a new 2D array--> SC: O(n)
        //space complexity is O(n) because of the output array.
        // If you want to count everything (including output), it's O(n). otherwise O(1)
    }
}

// | Resource | Complexity |
// | -------- | ---------- |
// | Time     | O(n log n) |
// | Space    | O(n)       |



/*

//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];
        int index = 0;

        for (int i = 0; i <= n - 3; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            result[index++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }

        return result;
    }
}


*/