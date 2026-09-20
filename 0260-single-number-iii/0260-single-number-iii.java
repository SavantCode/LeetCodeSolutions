class Solution {
    public int[] singleNumber(int[] nums) {
        int result[] = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        for(int val : nums){
            

            if(set.contains(val)){
                
                set.remove(val);
            }else{
                set.add(val);
            }
        }

        for(int x : set){
            result[idx] = x;
            idx++;
        }

        return result;
    }
}