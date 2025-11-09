//Space Complexity: O(1)
// Time Complexity: O(max(num1, num2))

class Solution {
    public int countOperations(int num1, int num2) {
        int nOp = 0;
        while( num1 != 0 && num2 != 0){
            if(num1 > num2 ){
                num1 = num1 - num2;
                nOp++;
            }else{ //num1 < num2 
                num2 = num2 - num1;
                nOp++;
            }
        }

        return nOp;
    }
}