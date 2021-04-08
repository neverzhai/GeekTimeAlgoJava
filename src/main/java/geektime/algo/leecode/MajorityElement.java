package geektime.algo.leecode;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-07 17:49
 * @description: 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class MajorityElement {

    public static void main(String[] args) {
        
        int[] nums = {3,3,4};
        int element1 = majorityElement1(nums);
        System.out.println(element1);

    }

    // method1: 哈希表法
    public static int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (hashMap.containsKey(nums[index])) {
                hashMap.put(nums[index], hashMap.get(nums[index]) + 1);
            } else {
                hashMap.put(nums[index], 1);
            }
        }
        int max = 0;
        int ans = nums[0];
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
            Integer number = hashMap.get(key);
            if (number.intValue() > max) {
                ans = key;
                max = number;
            }
        }

        return ans;
    }



    // method2: 摩尔投票法思路
    // 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
    //当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
    //当票数count为0时，更换候选人，并将票数count重置为1。
    //遍历完数组后，cand_num即为最终答案。
    //
    public int majorityElement2(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            }
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;

    }
}
