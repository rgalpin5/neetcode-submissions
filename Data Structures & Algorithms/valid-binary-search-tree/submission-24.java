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
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode root, long smallest, long largest) {
        if(root == null) return true;
        else if(root.val <= smallest || root.val >= largest) return false;
        else {
            return valid(root.left, smallest, root.val) && valid(root.right, root.val, largest);
        }
    }
    
}

