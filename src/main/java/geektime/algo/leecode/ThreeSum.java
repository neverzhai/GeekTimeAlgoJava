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
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length <= 2) {
            return result;
        }
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (num[0] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i-1]) continue;;
            int left = i +1, right = num.length -1;
            int target = -num[i];
            while (left < right) {
                if (num[left] + num[right] == target) {
                    result.add(Arrays.asList(num[i], num[left], num[right]));
                    left++;
                    right--;
                    while (left< right && num[left] == num[left-1]) {
                        left++;
                    }
                    while (left< right && num[right] == num[right+1]) {
                        right--;
                    }
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}