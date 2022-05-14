package geektime.algo.leecode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:49
 * @description: 20. 有效的括号
 * tag: 栈
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "{[]}";

        boolean valid = isValid(s);

    }

    public static boolean isValid(String s) {
        if (s.length() % 2 ==1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        LinkedList<Character> stack = new LinkedList<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(ch))) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
