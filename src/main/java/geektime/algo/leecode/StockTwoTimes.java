package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:34
 * @description:
 */
public class StockTwoTimes {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profitOne0 = 0, profitOne1 = -prices[0], profitTwo0 = 0, profitTwo1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            profitTwo0 = Math.max(profitTwo0, profitTwo1 + prices[i]);
            profitTwo1 = Math.max(profitTwo1, profitOne0 - prices[i]);
            profitOne0 = Math.max(profitOne0, profitOne1 + prices[i]);
            profitOne1 = Math.max(profitOne1, -prices[i]);
        }
        return profitTwo0;
    }
}