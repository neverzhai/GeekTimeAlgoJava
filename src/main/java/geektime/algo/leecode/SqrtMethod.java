package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-22 19:42
 * @description: 求平方根
 */
public class SqrtMethod {

    public static void main(String[] args) {
        double sqrt = sqrt(2.0, 0.001);
        System.out.println(sqrt);
    }

    public static double sqrt(double value, double error) {
        double left = 0;
        double right = value > 1 ? value : 1;
        while (right - left > error) {
            double middle = (right - left) / 2 + left;
            if (middle * middle < value) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (right - left) / 2 + left;
    }
}