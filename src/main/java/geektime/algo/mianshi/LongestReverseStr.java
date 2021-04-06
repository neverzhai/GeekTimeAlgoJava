package geektime.algo.mianshi;

import java.util.HashMap;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 10:56
 * @description: 最长回文串
 */
public class LongestReverseStr {

    public static void main(String[] args) {
        String str = "getref";
        String subString = longestSubString(str);
        System.out.println(subString);

        String abacab = longestPalindrome("abaab");
        System.out.println(abacab);

    }
    // 最长不重复子串
    public static String longestSubString (String str) {
       if (str.length() <=1) {
           return str;
       }
       int maxLength = 0;
       int firstIndex = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int start =0, end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch) +1);
            }
            if (maxLength < end - start + 1) {
                maxLength = end - start +1;
                firstIndex = start;
            }
            map.put(ch, end);
        }
        System.out.println(maxLength);
        System.out.println(firstIndex);

        return str.substring(firstIndex, firstIndex + maxLength);
    }



    // 最长回文串
    public static String longestPalindrome(String str) {
        //边界条件
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        char[] charArray = str.toCharArray();


        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 0;
        int start = 0;

        for (int j = 0; j < len; j++) {
            for (int i =0; i< j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i +1;
                    start = i;
                }
            }
        }

        return str.substring(start, start + maxLen);

    }

}
