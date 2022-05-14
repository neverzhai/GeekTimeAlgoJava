package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 21:19
 * @description: 判断一个整数是否是2的N次幂
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(n & (n-1));
//        System.out.println( n/2);
        boolean power = isPowerOfTwo(n);
        System.out.println(power);
    }

    // method1
//    判断奇偶
//    (x & 1) == 1 ---等价---> (x % 2 == 1)
//            (x & 1) == 0 ---等价---> (x % 2 == 0)
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while ((n & 1) == 0) {
            n/=2;
        }

        return n==1;

    }

    // method2
//    若 n = 2^xn=2
//    x
//    且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
//    恒有 n & (n - 1) == 0，这是因为：
//    nn 二进制最高位为 11，其余所有位为 00；
//    n - 1n−1 二进制最高位为 00，其余所有位为 11；
//    一定满足 n > 0。
    public static boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }

        return  n > 0 && (n & (n-1)) == 0;

    }
}
