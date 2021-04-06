package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-16 00:00
 * @description:
 */
public class MostWaterContainer {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int start = 0, end = height.length -1; start < end ; ) {
            int minHeight = height[start] < height[end] ? height[start++]: height[end--];
            maxArea = Math.max(minHeight * (end - start + 1), maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int max = maxArea(new int[] {1,8,6,2,5,4,8,3,7});

        System.out.println(max);

    }
}