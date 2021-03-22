package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:43
 * @description:
 */
public class StockWithCodeTim {


    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
            }
            return dp[length - 1][0];
        }
    }

    // 优化
    class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int prevProfit0 = 0, profit0 = 0, profit1 = -prices[0];
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                int nextProfit0 = Math.max(profit0, profit1 + prices[i]);
                int nextProfit1 = Math.max(profit1, prevProfit0 - prices[i]);
                prevProfit0 = profit0;
                profit0 = nextProfit0;
                profit1 = nextProfit1;
            }
            return profit0;
        }
    }
}