package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:41
 * @description:
 */
public class StockMuiltTimeWihtFee {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0] - fee;
            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return dp[length - 1][0];
        }
    }


    // 优化
    class Solution1{
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int profit0 = 0, profit1 = -prices[0] - fee;
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                int newProfit0 = Math.max(profit0, profit1 + prices[i]);
                int newProfit1 = Math.max(profit1, profit0 - prices[i] - fee);
                profit0 = newProfit0;
                profit1 = newProfit1;
            }
            return profit0;
        }
    }
}