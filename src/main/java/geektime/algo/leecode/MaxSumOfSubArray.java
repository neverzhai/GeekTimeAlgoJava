package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 23:49
 * @description:
 */
public class MaxSumOfSubArray {
    public int maxsumofSubarray (int[] arr) {
        int res = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i] += Math.max(arr[i - 1], 0);
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}