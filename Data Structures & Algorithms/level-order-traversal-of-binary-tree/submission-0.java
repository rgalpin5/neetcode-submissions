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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> levelList = new ArrayList<>();
        if(root == null) return levelList;
        TreeNode traverse = root;
        maxLen(0, root, levelList);
        addToList(0, root, levelList);
        return levelList;
    }

    public static void addToList(int i, TreeNode root, List<List<Integer>> list){
        
        if(root == null) return;
        list.get(i).add(root.val);
        if(root.left != null) addToList(i+1, root.left, list);
        if(root.right != null) addToList(i+1, root.right, list);
    }

    public static void maxLen(int level, TreeNode root, List<List<Integer>> list){
        if(root == null) return;
        
        if(level+1 > list.size()){
            list.add(new ArrayList<Integer>());
        }
        maxLen(level+1, root.left, list);
        maxLen(level+1, root.right, list);
    }
}
