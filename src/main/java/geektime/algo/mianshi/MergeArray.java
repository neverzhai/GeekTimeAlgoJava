package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 10:04
 * @description: 合并两个排序的数组A,B, A有足够的空间存放B的元素
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {2,4,6,8, 0,0,0,0, 0,0};
        int[] nums2 = {1,3,5,6};

        merge(nums1, 4, nums2,4);
        for (int i = 0; i< nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int len1, int[] nums2, int len2) {
        int maxIndex = len1 + len2 -1;
        int i = len1-1;
        for (int j = len2 -1; j >=0; j--) {
            while (i >= 0 && nums2[j] < nums1[i]) {
                nums1[maxIndex--] = nums1[i--];
            }
            nums1[maxIndex--] = nums2[j];
        }

    }

}
