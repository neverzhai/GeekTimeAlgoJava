package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-03-23 19:48
 * @description:
 */
public class MaxDiff {

    public static void main(String[] args) {
        int[] numbers = new int[]{100, 80, 120, 130, 70, 60, 100, 125};
        int maxDiff = maxDiff(numbers);
        System.out.println(maxDiff);

        int maxProfit = maxProfit(numbers);

        System.out.println(maxProfit);
    }

    // 一次交易获取最大利润
    public static int maxDiff(int[] numbers) {

        if (numbers.length < 2) {
            return 0;
        }

        int minNum;
        int maxNum;
        int maxDiff = 0;
        int index = 0;
        while (index < numbers.length - 1) {
            while (index < numbers.length - 1 && numbers[index] >= numbers[index + 1]) {
                index++;
            }
            minNum = numbers[index];

            while (index < numbers.length - 1 && numbers[index] <= numbers[index + 1]) {
                index++;
            }
            maxNum = numbers[index];

            maxDiff += maxNum - minNum;
        }
        return maxDiff;
    }

    // 不限制交易次数， 获得最大利润
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //两次交易获得最大利润


}