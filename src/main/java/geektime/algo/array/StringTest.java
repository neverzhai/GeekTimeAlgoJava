package geektime.algo.array;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-05-06 10:01
 * @description:
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "barbrcdd";
        String test = test(str);
        System.out.println(test);
    }

    public static String test(String str) {
        char[] chars = str.toCharArray();

        char[] result = new char[chars.length];
        int start = 0, index = 0;

        while (start < chars.length) {
            if (chars[start] == '0') {
                start++;
                continue;
            }
            char curr = chars[start];
            result[index++] = curr;
            for (int i = start +1; i<chars.length; i++) {
                if (chars[i] == curr) {
                    result[index++] = curr;
                    chars[i] = '0';
                }
            }
            start++;
        }
        return new String(result);
    }
}