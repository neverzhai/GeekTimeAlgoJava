package geektime.algo.mianshi;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-22 17:51
 * @description:
 */
public class SqrtMethod {

    public static void main(String[] args) {
        double sqrt = sqrt(0.5, 0.001);
        System.out.println(sqrt);
    }

    public static double sqrt(double value, double error) {
       double left = 0;
       double right = value > 1 ? value : 1;
       while (right - left > error) {
           double middle = (right - left) /2 + left;
           if (middle *  middle - value > error) {
               right = middle;
           } else {
               left = middle;
           }
       }

       return (right - left) /2 + left;
    }
}
