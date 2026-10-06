class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;

        int n = prices.length;
        int buy = prices[0];
        // int sell = -1;
        for(int i = 1 ; i < n; i++){

            if(prices[i] < buy){
                buy = prices[i];
            
            }else{
                int currProfit = prices[i] - buy ;
                maxProfit = Math.max(currProfit, maxProfit);
            }


        }
        return maxProfit;
    }
}