/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> nodeCopies = new HashMap<>();
        Node start = new Node(node.val);
        queue.offer(node);
        queue.offer(start);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            Node copyOfCurr = queue.poll();
            if(!nodeCopies.containsKey(currNode)) {
                nodeCopies.put(currNode, copyOfCurr);
            }
            System.out.println(nodeCopies.toString() + " " + currNode.val);
            copyOfCurr.val = currNode.val;
            for(Node nei : currNode.neighbors) {
                if(!nodeCopies.containsKey(nei)){
                    Node newNei = new Node(nei.val);
                    copyOfCurr.neighbors.add(newNei);
                    nodeCopies.put(nei, newNei);
                    queue.offer(nei);
                    queue.offer(newNei);
                }
                else{
                    copyOfCurr.neighbors.add(nodeCopies.get(nei));
                }
            }
        }

        return start;
    }
}