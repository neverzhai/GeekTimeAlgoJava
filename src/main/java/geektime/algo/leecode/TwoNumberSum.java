package geektime.algo.leecode;

import java.util.HashMap;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-01-19 21:55
 * @description: 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
public class TwoNumberSum {

    // 暴力解法
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for(int j = i +1; j < length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};
    }

    // 查表法---借助hash表减少一次循环
    public int[] twoSumWithHash(int[] nums, int target) {
        HashMap<Integer, Integer> tempTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (tempTable.containsKey(value)) {
                return new int[] {tempTable.get(value), i};
            }
            tempTable.put(nums[i], i);
        }
        return new int[]{};
    }


}