package geektime.algo.leecode.top100Medium;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-12 09:12
 * @description:  338. 比特位计数
 */
public class CountBits {

    // 对于所有的数字，只有两类：
    //
    //奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。


    //偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
    //

    public int[] countBits(int num) {

        int[] result = new int[num +1];
        result[0] = 0;

        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i-1] +1;
            } else {
                result[i] = result[i/2];
            }
        }
        return result;
    }


}
