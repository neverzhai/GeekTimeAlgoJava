package geektime.algo.leecode.hard;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-20 14:28
 * @description: 将字符串转成整数
 * 注意考虑不同的边界情况
 */
public class Atoi {

    public static int atoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        int sign = 1, index = 0;
        if (chars[0] == '+') {
            index++;
        } else if (chars[0] == '-') {
            sign = -1;
            index++;
        }
        int num = 0;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] - '0' >= 0 && chars[i] - '9' <= 0) {
                if (num > Integer.MAX_VALUE /10 || num == Integer.MAX_VALUE/10 && chars[i] - '7' >0) {
                    if (sign > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }

                num = num * 10 + chars[i] - '0';
            } else {
                break;
            }
        }
        return num * sign;
    }
}