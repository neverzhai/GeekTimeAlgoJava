package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 08:16
 * @description:
 */
public class LCS {
    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        int subSeriel = longestSubSeriel(str1, str2);
        System.out.println(subSeriel);

    }

    // 动态规划 -- 最长公共子串
    public String longestSubString (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 +1][len2 + 1];
        int bigestLength = 0;
        int maxLen = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
//                    bigestLength = Math.max(bigestLength, dp[i+1][j+1]);
                    if (dp[i+1][j+1] > bigestLength) {
                        bigestLength = dp[i+1][j+1];
                        maxLen = j;
                    }
                }
            }
        }
        System.out.println(maxLen);
        System.out.println(bigestLength);
//        printDP(dp, len1 + 1, len2 +1);
        return str2.substring(maxLen - bigestLength +1, maxLen +1);
    }



    // 最长公共子序列
    public static int longestSubSeriel(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[len1][len2];
    }

}