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
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        dfs(0, root);
        return ans;
    }
    private void dfs(int index, TreeNode root){
        if(root == null) return;
        if(ans.size() < index + 1) {
            ans.add(index, new ArrayList<>());
        }
        ans.get(index).add(root.val);
        dfs(index + 1, root.left);
        dfs(index + 1, root.right);
    }
}
