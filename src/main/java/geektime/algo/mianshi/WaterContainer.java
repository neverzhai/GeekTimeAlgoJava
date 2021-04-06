package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-24 09:54
 * @description: 盛水最多的容器
 */
public class WaterContainer {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int maxArea = getMaxArea(nums);
        System.out.println(maxArea);
    }

    private static int getMaxArea(int[] nums) {
        int left = 0, right = nums.length -1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = nums[left] < nums[right] ? nums[left++] : nums[right--];
            maxArea = Math.max(maxArea, minHeight * (right - left + 1));
        }
        return maxArea;
    }
}
