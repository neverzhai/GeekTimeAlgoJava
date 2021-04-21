package geektime.algo.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-21 10:39
 * @description: 15. 三数之和
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) continue;;
            int left = i +1, right = nums.length -1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left< right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left< right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}