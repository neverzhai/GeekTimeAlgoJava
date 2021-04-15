package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-15 09:29
 * @description: 111. 二叉树的最小深度 && 最大深度
 *
 * DFS VS BFS
 */
public class MinORMaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 递归 -- 最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return  right + 1;
        }
        if (right == 0) {
            return left +1;
        }

        return Math.min(left, right) +1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth1(root.right) +1;
        }
        if (root.right ==  null) {
            return minDepth1(root.left) +1;
        }

        return Math.min(minDepth1(root.right), minDepth1(root.left)) +1;
    }

    // 递归 -- 最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;

    }
}
