package geektime.algo.leecode.top100Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-14 09:00
 * @description: 22. 括号生成
 */
public class GenerateParenthesis {

    // method1---暴力法




    // method2---回溯法
    List<String> ans = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), 0, 0, n);
        return ans;

    }

    private void backTrack(StringBuilder curr, int left, int right, int max) {
        if (left == max && right == max) {
            ans.add(curr.toString());
            return;
        }

        if (left < max) {
            curr.append("(");
            backTrack(curr, left+1, right, max);
            curr.deleteCharAt(curr.length() -1);
        }

        if (left > right && right < max) {
            curr.append(")");
            backTrack(curr, left, right+1, max);
            curr.deleteCharAt(curr.length() -1);
        }
    }
}
