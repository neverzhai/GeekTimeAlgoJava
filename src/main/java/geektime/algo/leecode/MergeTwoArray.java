package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-15 10:41
 * @description:  合并两个有序数组
 */
public class MergeTwoArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int maxIndex = m + n - 1;
        int index1 = m -1;
        for (int i = n-1; i >= 0; i--) {
            while (index1 >= 0 && nums1[index1] >= nums2[i]) {
                nums1[maxIndex--] = nums1[index1--];
            }
            nums1[maxIndex--] = nums2[i];
        }

    }
}
