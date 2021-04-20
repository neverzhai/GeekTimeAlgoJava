package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-20 14:50
 * @description: 十进制转换成N进制
 */
public class ReverseToN {
    public String solve (int M, int N) {
        // write code here
        if (M == 0) {
            return "0";
        }
        int sign = 1;
        if (M < 0) {
            sign = -1;
            M = -M;
        }

        StringBuilder builder = new StringBuilder();
        while (M >0) {
            int k = M % N;
            if (k >= 10) {
               builder.append((char)(k- 10 + 'A'));
            } else {
                builder.append(k);
            }
            M/=N;
        }
        if (sign < 0) {
            builder.append('-');
        }
        return builder.reverse().toString();
    }

}