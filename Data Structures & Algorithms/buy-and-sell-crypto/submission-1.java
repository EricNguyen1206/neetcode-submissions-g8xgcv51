class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int amount = 0;
        for (int i = 0; i<prices.length; i++) {
            if (prices[i]<buy) {
                buy = prices[i];
            } else {
                amount = Math.max(amount, prices[i] - buy);
            }
        }

        return amount;
    }
}
