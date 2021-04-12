package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 21:19
 * @description: 判断一个整数是否是2的N次幂
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        isPowerOfTwo1(n);

//        System.out.println(n / 2);
    }

    public  static  boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
//        long x = (long) n;
        return (n & (n-1)) == 0;

    }
}