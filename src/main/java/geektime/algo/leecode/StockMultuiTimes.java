package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:33
 * @description:
 */
public class StockMultuiTimes {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int pro0 = 0;
        int pro1 = -prices[0];

        for (int index = 1; index < length; index++) {
            int newPro0 = Math.max(pro0, pro1 + prices[index]);
            int newPro1 = Math.max(pro1, pro0 - prices[index]);
            pro0 = newPro0;
            pro1 = newPro1;
        }

        return pro0;
    }
}