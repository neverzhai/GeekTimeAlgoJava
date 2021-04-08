package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:47
 * @description: 283. 移动零
 *
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public static void main(String[] args) {
       int[] nums = {1,0};

       moveZeroes(nums);

        for (int item : nums) {
           System.out.println(item);
        }

    }


    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0;

        for(int right = 0; right < n; right++) {
           if (nums[right] != 0) {
               swap(nums, left, right);
               left++;
           }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
