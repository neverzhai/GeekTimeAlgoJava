package geektime.algo.leecode;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-21 21:41
 * @description: 红包算法
 */
public class RedPackage {

    public static List sendRedPackage(double value, int number) {
        ArrayList<BigDecimal> result = new ArrayList<>();
        if (value <= 0 || number<= 0) {
            return result;
        }
        double start = 0, end = value;
        for (int count = 0; count < number -1; count++) {
            double curr = 0;
            double amount = nextValue(start, end);
            curr = amount - start;
            result.add(BigDecimal.valueOf(curr));
            start = amount;
        }

        result.add(BigDecimal.valueOf(end - start));

        return result;

    }

    public static List sendRedPackage2(double value, int number) {
        ArrayList<BigDecimal> result = new ArrayList<>();
        if (value <= 0 || number<= 0) {
            return result;
        }
        double amount , sum = 0;
        int remainNumber = number;

        while (remainNumber > 0) {
            amount = nextValue(0.01, value / number * 2);
//            sum += amount;
            remainNumber--;
            value -= amount;
            result.add(BigDecimal.valueOf(amount));
        }
        result.add(BigDecimal.valueOf(value));
//        System.out.println(sum);
//        System.out.println(value);
//        System.out.println("-------");
        return result;
    }

    private static double nextValue(double start, double end) {
        return (end - start) * new Random().nextDouble() + start;
    }

    public static void main(String[] args) {
        List<BigDecimal> redPackage = sendRedPackage2(100, 12);
        for (BigDecimal value: redPackage) {
            System.out.println(value);
        }
    }
}