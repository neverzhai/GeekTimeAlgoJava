package geektime.algo.leecode.top100Medium;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-14 10:08
 * @description:  48. 旋转图像
 */
public class RotateMatrix {

    // method1: 辅助数组
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                new_matrix[j][n -i -1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new_matrix[i][j];
            }
        }
    }


    //method2: 两次翻转代替旋转
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
