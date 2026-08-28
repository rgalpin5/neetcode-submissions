/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.left.val >= root.val) return false;
        if(root.right != null && root.right.val <= root.val) return false;
        return dfs(root.right, root.val, Integer.MAX_VALUE) && dfs(root.left, Integer.MIN_VALUE, root.val);
    }

    private boolean dfs(TreeNode root, int minVal, int maxVal){
        if(root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;

        return dfs(root.left, minVal, root.val) && dfs(root.right, root.val, maxVal);

    }
    
}
