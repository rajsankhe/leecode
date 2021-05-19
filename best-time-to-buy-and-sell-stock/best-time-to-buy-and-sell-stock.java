class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min_price = prices[0];
        
        if (prices.length == 0) {
            return maxProfit;
        }
       
        for(int i =1 ; i< prices.length; i++) {
            if (prices[i] < min_price){
                min_price = prices[i];
            }
            
            if(prices[i] - min_price > maxProfit) {
                    maxProfit = prices[i] - min_price;
            }
        }
        
        return maxProfit;
    }
}