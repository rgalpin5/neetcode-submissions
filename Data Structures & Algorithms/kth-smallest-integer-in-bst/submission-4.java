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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        dfs(root, k, minHeap);
        TreeNode curr = root;
        while(k > 0) {
            curr = minHeap.poll();
            k--;
        }
        return curr.val;
    }

    private boolean dfs(TreeNode root, int k, PriorityQueue<TreeNode> heap) {
        if(root == null) return true;
        dfs(root.left, k, heap);
        dfs(root.right, k, heap);
        heap.offer(root);
        return true;
    }
}
