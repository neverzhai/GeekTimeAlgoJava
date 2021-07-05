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
        if(p.val > q.val) { // 保证 p.val < q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if(root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if(root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;

    }

    // 迭代
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) { // 保证 p.val < q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    // 二叉搜索树的最近公共祖先 -- 利用搜索树的特点 -- 递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
