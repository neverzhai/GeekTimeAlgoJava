package geektime.algo.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-22 22:33
 * @description:
 */
public class BinaryTreeTest {

      public class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;
      }

    public int[][] threeOrders (TreeNode root) {
        List<Integer> preResult = new ArrayList<>();
        preOrder(root, preResult);
        List<Integer> inResult = new ArrayList<>();
        inOrder(root, inResult);
        List<Integer> postResult = new ArrayList<>();
        postOrder(root, postResult);

        int[][] result = new int[3][preResult.size()];
        for (int index = 0; index < preResult.size(); index++) {
            result[0][index] = preResult.get(index);
            result[1][index] = inResult.get(index);
            result[2][index] = postResult.get(index);
        }

        return result;
        // write code here
    }

    public static void preOrder(TreeNode root, List result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static void inOrder(TreeNode root, List result) {
        if (root == null) {
            return;
        }
        preOrder(root.left, result);
        result.add(root.value);
        preOrder(root.right, result);
    }

    public static void postOrder(TreeNode root, List result) {
        if (root == null) {
            return;
        }
        preOrder(root.left, result);
        preOrder(root.right, result);
        result.add(root.value);
    }

}