package geektime.algo.leecode.top100Medium;

import java.util.Arrays;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-14 21:42
 * @description:  322. 零钱兑换
 */
public class CoinChange {

    // 动态规划
    public int coinChange(int[] coins, int amount) {
        int n = amount +1;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i =1; i<=amount; i++) {
            for (int j= 0; j< coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
                }
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}