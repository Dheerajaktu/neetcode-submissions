class Solution {
    /* Approach::
     Basically in real life we buy stocks and sell them to gain maximum profit. Here, we traverse
   the array from left to right.
   As per the question:
   - We must buy first.
   - We must sell after buying.
   - We cannot buy and sell on the same day.

   So for every current price, we ask:  "If I sell today, what will be my profit?"
   Formula:  profit = todayPrice - minimumBuyingPriceSoFar.  But when we start from index 0, there
   is no previous day.

   So initially we store the first stock price as our minimum buying price:  minPrice = prices[0];
   Then we start traversing from index 1.
   For every price:  profit = currentPrice - minPrice;  If this profit is greater than our previous maximum profit,
   update maxProfit.   maxProfit = Math.max(maxProfit, profit);
    After checking today's profit, we also check: "Is today's price cheaper than my previous minimum buying price?"
    If yes, update minPrice:  minPrice = Math.min(minPrice, currentPrice);
    HaPpY LeArNiNg!
    */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minProfit = prices[0];
        int maxProfit = 0;

        for(int i = 0; i<n; i++){
            int profit = prices[i] - minProfit;
            maxProfit = Math.max(profit, maxProfit);
            minProfit = Math.min(prices[i], minProfit);
        }

        return maxProfit;
    }
}
