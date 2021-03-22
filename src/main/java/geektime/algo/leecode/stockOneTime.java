package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 09:30
 * @description:
 */
public class stockOneTime {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            int pro0 = 0;
            int pro1 = -prices[0];
            for(int index = 1; index < length; index++) {
                pro0 = Math.max(pro0, pro1 + prices[index]);
                pro1 = Math.max(pro1, -prices[index]);
            }

            return pro0;
        }
}