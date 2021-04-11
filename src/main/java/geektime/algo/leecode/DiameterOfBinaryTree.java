package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-08 08:48
 * @description: 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {

//     * Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
          depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = depth(root.left);
        int R = depth(root.right);
        max = Math.max(L + R, max);
        return Math.max(L, R) +1;

    }
}
