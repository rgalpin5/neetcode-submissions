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
        return search(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean search(TreeNode node, int left, int right){
        if(node == null) return true;
        
        if(!(left < node.val && node.val < right)){
            return false;
        }

        return search(node.left, left, node.val) && search(node.right, node.val, right);
    }
}
