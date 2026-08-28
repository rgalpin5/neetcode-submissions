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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> intQueue = new LinkedList<>();

        nodeQueue.offer(root);
        intQueue.offer(root.val);

        while(!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            if(curr == null) continue;
            if(curr.left != null){
                nodeQueue.offer(curr.left);
                intQueue.offer(curr.left.val);
            }
            else{
                nodeQueue.offer(null);
                intQueue.offer(Integer.MAX_VALUE);
            }
            if(curr.right != null){
                nodeQueue.offer(curr.right);
                intQueue.offer(curr.right.val);
            }
            else{
                nodeQueue.offer(null);
                intQueue.offer(Integer.MAX_VALUE);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!intQueue.isEmpty()) {
            int currNum = intQueue.poll();
            if(currNum == Integer.MAX_VALUE){
                sb.append("N");
            }
            else{
                sb.append(currNum);
            }
            sb.append("#");
        }
        System.out.println(sb.toString());
        return sb.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] vals = data.split("#");
        TreeNode head = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int[] nums = new int[vals.length];
        int i = 0;
        for(String str : vals) {
            if(str.equals("N")) {
                nums[i] = 1001;
            }
            else{
                nums[i] = Integer.parseInt(str);
            }
            i++;
        }
        queue.offer(head);
        int idx = 1;
        while(idx < vals.length && !queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode == null) continue;
            if(nums[idx] == 1001) {
                currNode.left = null;
            }
            else{
                currNode.left = new TreeNode(nums[idx]);
            }
            idx++;
            if(nums[idx] == 1001) {
                currNode.right = null;
            }
            else{
                currNode.right = new TreeNode(nums[idx]);
            }
            idx++;
            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }
        return head;
        
    }
}
