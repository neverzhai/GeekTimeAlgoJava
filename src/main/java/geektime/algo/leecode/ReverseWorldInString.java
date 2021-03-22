package geektime.algo.leecode;



/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-03 21:37
 * @description:  151：翻转字符串里的单词
 */
public class ReverseWorldInString {

    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        reverse(sb, 0, sb.length() -1);

        reverseEachWorld(sb);

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {

    }

    private void reverseEachWorld(StringBuilder sb) {
    }

    private StringBuilder trimSpaces(String s) {
        return null;
    }
}