package geektime.algo.leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-18 00:03
 * @description:
 */
public class BinaryTreeTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        // 先序递归
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorderInternal(root, result);
            return result;
        }

        private void preorderInternal(TreeNode node, List result) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            preorderInternal(node.left, result);
            preorderInternal(node.right, result);
        }

        // 先序非递归
        public List<Integer> preOrderTraverse2(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode pNode = root;
            while (pNode != null || !stack.isEmpty()) {
                if (pNode != null) {
                    result.add(pNode.val);
                    stack.push(pNode);
                    pNode = pNode.left;
                } else { //pNode == null && !stack.isEmpty()
                    TreeNode node = stack.pop();
                    pNode = node.right;
                }
            }

            return result;
        }

        // 中序递归
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderInternal(root, result);
            return result;
        }

        private void inorderInternal(TreeNode node, List result) {
            if (node == null) {
                return;
            }
            preorderInternal(node.left, result);
            result.add(node.val);
            preorderInternal(node.right, result);
        }

        // 中序非递归
        public List<Integer> inOrderTraverse2(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode pNode = root;
            while (pNode != null || !stack.isEmpty()) {
                if (pNode != null) {
                    stack.push(pNode);
                    pNode = pNode.left;
                } else { //pNode == null && !stack.isEmpty()
                    TreeNode node = stack.pop();
                    result.add(node.val);
                    pNode = node.right;
                }
            }

            return result;
        }
        // 后序递归
        public List<Integer> postOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postOrderInternal(root, result);
            return result;
        }

        private void postOrderInternal(TreeNode node, List result) {
            if (node == null) {
                return;
            }
            postOrderInternal(node.left, result);
            postOrderInternal(node.right, result);
            result.add(node.val);
        }

        // 后续非递归
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
}