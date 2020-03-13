package geektime.algo.mianshi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-03-08 09:27
 * @description: 两个超长大数相加
 */
public class AddLongInteger {
    public static void main(String[] args) {
        String a = "99999999999999999999999999999999999999999999999999";
        String b = "1";
        BigInteger add = add(a, b);
        System.out.println(add);

        String integer = AddLongInteger(a, b);
        System.out.println(integer);


    }

    // 使用bigInteger

    public static BigInteger add ( String a, String b) {
        BigInteger integer = new BigInteger(a);
        BigInteger bigInteger = new BigInteger(b);
        return integer.add(bigInteger);
    }

    public static String AddLongInteger(String a,String b){
        // 求出两个字符串中较长的那个字符串长度
        int lenA = a.length();
        int lenB = b.length();
        int lenS = Math.max(lenA, lenB);

        // arrS保存最终生成的结果
        int[] arrA = new int[lenS];
        int[] arrB = new int[lenS];
        int[] arrS = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = a.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arrB[i] = b.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arrS[i] + arrA[i] + arrB[i];
            int flag = sum /10;
            arrS[i]  = sum % 10;
            arrS[i+1] += flag;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = arrS[lenS] == 0?1:0; i < lenS + 1; i++) {
            stringBuffer.append(arrS[lenS - i]);
        }

        return stringBuffer.toString();

}

}
