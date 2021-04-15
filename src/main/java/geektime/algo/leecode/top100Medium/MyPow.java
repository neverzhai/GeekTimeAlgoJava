package geektime.algo.leecode.top100Medium;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-15 09:28
 * @description: 50. Pow(x, n)
 */
public class MyPow {

    // method1 -- 分治 + 递归
    public double myPow(double x, int n) {
        long N = n;

        return N >=0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);

        return N % 2 == 0 ? y*y : y*y*x;
    }


    // method2 -- 分治 + 迭代
    public double myPow1(double x, int n) {
        long N = n;

        return N >=0 ? quickMul1(x, N) : 1.0 / quickMul1(x, -N);
    }

    private double quickMul1(double x, long N) {
        double ans = 1.0;

        double x_contribute = x;

        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribute;
            }

            x_contribute *= x_contribute;
            N /=2;
        }
        return ans;
    }
}
