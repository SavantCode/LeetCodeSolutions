class Solution {
    //lo : low
    //hi : high

    public TreeNode helper(int[] nums, int lo, int hi){
        if(lo>hi) return null;
        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid-1);
        root.right = helper(nums, mid + 1, hi);
        return root;

    }


    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(nums , 0 , n-1);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(log n) (excluding the output tree)
*/