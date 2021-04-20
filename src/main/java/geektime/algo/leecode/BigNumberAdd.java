package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-20 16:21
 * @description: 大数加法
 */
public class BigNumberAdd {

    public String solve (String s, String t) {
        int i = s.length() - 1, j = t.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? s.charAt(i) - '0' : 0;
            int y = j >= 0 ? t.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}