package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-23 09:21
 * @description: 最长公共子序列/子串
 */
public class LCS {

    public static void main(String[] args) {
        String str1 = "abcfdeu";
        String str2 = "cfdeio";

        String longestLength = longestLengthForString(str1, str2);
        System.out.println(longestLength);
    }

    public static int longestLength(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        printDP(dp, len1 + 1, len2 +1);
        return dp[len1][len2];
    }

    // 简化 减少使用空间
    public static int longestLength2(String text1, String text2) {
        int[] dp = new int[text2.length()+1];

        for(int i = 0; i < text1.length(); i++){
            int pre = 0;//为了记录dp[i][j]
            for(int j = 0; j < text2.length(); j++){
                int curr = dp[j+1];
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[j+1] = pre+1;
                }else{
                    dp[j+1] = Math.max(dp[j],dp[j+1]);//相当于求Math.max(dp[i+1][j],dp[i][j+1])，按照更新时间来说，dp[j+1]还没被更新，代表上一轮的值
                }
                pre = curr;
            }
        }
        return dp[text2.length()];
    }

    // 最长公共子串长度
    public static String longestLengthForString(String str1, String str2) {
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

    public static int longestLengthForString2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[] dp = new int[len2 + 1];
        int bigestLength = 0;
        int maxEnd = 0;


        for (int i = 0; i < len1; i++) {
            int pre = 0;
            for (int j = 0; j < len2; j++) {
                int curr = dp[j+1];
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j+1] = pre + 1;
                    if (dp[j] > bigestLength) {
                        bigestLength = dp[j];
                        maxEnd = j;
                    }
                }
                pre = curr;
            }
        }
//        printDP(dp, len1 + 1, len2 +1);
        return bigestLength;
    }




    public static String longestPalindrome(String s1, String s2) {
//        if (s.equals("")) {
//            return "";
//        }
//        String origin = s;
//        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置

        int length = s1.length();
        int len2 = s2.length();
        int[][] arr = new int[length][len2];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以 i 位置结尾的字符
                }

            }
        }
return s1.substring(maxEnd - maxLen + 1, maxEnd + 1);
}

    public static  void  printDP(int[][] dp, int len1, int len2) {
        for (int i = 0; i < len1; i ++) {
            for (int j = 0; j < len2; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

    }
}
