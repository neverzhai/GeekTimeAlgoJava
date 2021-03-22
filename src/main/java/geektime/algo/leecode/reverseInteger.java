package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-03-25 14:36
 * @description: 将一个32位整数反转
 * -2147483648~+2147483647
 */
public class reverseInteger {

    public static int reverse(int number) {
        int rev = 0;
        while (number != 0) {
            int pop = number % 10;
            System.out.println(Integer.MAX_VALUE /10);
            number = number / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                rev = 0;
                break;
            } else if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                rev = 0;
                break;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}