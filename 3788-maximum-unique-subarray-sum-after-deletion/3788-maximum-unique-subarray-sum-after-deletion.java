//Approach-2 (Using constant space)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int maxSum(int[] nums) {
        int[] mp = new int[101];
        Arrays.fill(mp, -1); // initialize to -1
        
        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num <= 0) {
                maxNeg = Math.max(maxNeg, num);
            } else if(mp[num] == -1) {
                sum += num;
                mp[num] = 1; 
            }
        }

        return sum > 0 ? sum : maxNeg;
    }
}

/*
//Approach-1 (Using set)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        int maxNeg = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num <= 0) {
                maxNeg = Math.max(maxNeg, num); 
            } else if(!set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }
        
        return sum == 0 ? maxNeg : sum;
    }
}
*/

/*
class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxSum = 0, currSum = 0;
        int i = 0; 

        for (int j = 0; j < nums.length; j++) {  
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                currSum -= nums[i];
                i++;  
            }
            set.add(nums[j]);
            currSum += nums[j];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
*/