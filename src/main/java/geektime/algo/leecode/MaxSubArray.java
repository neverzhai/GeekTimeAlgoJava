package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:48
 * @description: 53. 最大子序和
 */
public class MaxSubArray {


    // 动态规划, 状态转移方程: f(i)=max{f(i−1)+nums[i],nums[i]}

    // 未空间优化
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i -1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // 空间优化
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }

        return max;

    }
}
