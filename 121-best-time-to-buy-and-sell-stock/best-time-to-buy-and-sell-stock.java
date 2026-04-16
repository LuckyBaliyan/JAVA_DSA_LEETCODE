class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;

        int buy = prices[0];
        int sell = prices[0];

        for(int i = 0; i<n; i++){
            if(prices[i] < buy){
                buy = prices[i];
                sell = prices[i];
            }
            else{
                sell = prices[i];
                maxProfit = Math.max(maxProfit, sell - buy);
            }
        }

        return  maxProfit == Integer.MIN_VALUE? 0: maxProfit;
    }
}