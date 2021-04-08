package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 08:56
 * @description: 打家劫舍----动态规划
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,9,3,1};
        int result = rob(nums);
        System.out.println(result);
    }

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0] ;
        dp[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < nums.length; index++) {
            dp[index] = Math.max(dp[index-1], dp[index-2] + nums[index]);
        }
        return dp[nums.length -1];
    }
}
