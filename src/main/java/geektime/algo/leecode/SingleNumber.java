package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-12 09:29
 * @description: 136. 只出现一次的数字
 */
public class SingleNumber {


    // 因此，数组中的全部元素的异或运算结果即为数组中只出现一次的数字。
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
