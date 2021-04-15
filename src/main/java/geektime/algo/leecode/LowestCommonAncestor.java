package geektime.algo.leecode;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-15 09:24
 * @description: 二叉树的最近公共祖先 &&  二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

     // 二叉树的最近公共祖先
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null || root == p || root == q) {
             return root;
         }
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if (left == null) {
             return right;
         }
         if (right == null) {
             return left;
         }
         return root;
     }


    // 二叉搜索树的最近公共祖先 -- 利用搜索树的特点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

          return root;
    }
}
