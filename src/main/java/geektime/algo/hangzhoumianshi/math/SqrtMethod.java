package geektime.algo.hangzhoumianshi.math;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-07-06 11:43
 * @description: 开平方根
 */
public class SqrtMethod {


    // 1. 返回的结果是整数
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static double sqrt(double value, double error) {
        double left = 0;
        double right = value > 1 ? value : 1;
        while (right - left > error) {
            double middle = (right - left) / 2 + left;
            if (middle * middle < value) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (right - left) / 2 + left;
    }
}