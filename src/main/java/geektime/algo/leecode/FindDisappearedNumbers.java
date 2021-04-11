package geektime.algo.leecode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:46
 * @description:  448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

   // method: 原地修改数组,
   // 因为数组中的元素范围是 1<=nums[i] <= n;
    // 当前元素是 nums[i]nums[i]，那么我们把第 nums[i] - 1nums[i]−1 位置的元素 乘以 -1，表示这个该位置出现过。当然如果 第 nums[i] - 1nums[i]−1 位置的元素已经是负数了，表示 nums[i]nums[i] 已经出现过了，就不用再把第 nums[i] - 1nums[i]−1 位置的元素乘以 -1。最后，对数组中的每个位置遍历一遍，如果 ii 位置的数字是正数，说明 ii 未出现过。
   //

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i +1);
            }
        }

        return result;
    }

}
