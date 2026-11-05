class Solution {
    public int maxProfit(int[] prices) {
        int lowestPriceVisited = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < lowestPriceVisited) {
                lowestPriceVisited = price;
            }
            maxProfit = Math.max(maxProfit, price - lowestPriceVisited);
        }
        return maxProfit;
    }
}
