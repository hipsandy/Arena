package src.com.hipsandy.leet;

public class BalancedBinaryTree {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  static class Solution {

    public boolean isBalanced(TreeNode root) {
      if (root == null) return true;

      return height(root) != -1;
    }

    public int height(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int leftHt = height(node.left);
      int rightHt = height(node.right);

      if (leftHt == -1 || rightHt == -1 || Math.abs(leftHt - rightHt) > 1) {
        return -1;
      }

      return 1 + Math.max(leftHt, rightHt);
    }

  }

  class FirstSolution {

    public boolean isBalanced(TreeNode root) {
      if (root == null) return true;

      int leftHt = height(root.left);
      int rightHt = height(root.right);

      if (Math.abs(leftHt - rightHt) > 1) {
        return false;
      }

      return (isBalanced(root.left) && isBalanced(root.right));
    }

    public int height(TreeNode node) {
      if (node == null) {
        return 0;
      }

      if (node.left == null && node.right == null) {
        return 1;
      }

      return 1 + Math.max(height(node.left), height(node.right));
    }
  }

}
