public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {

    HashMap<Integer, Node> nodeValMap;
    Node head;
    Node tail;
    int maxSize;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        maxSize = capacity;
        nodeValMap = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(!nodeValMap.containsKey(key)) return -1;
        Node currNode = nodeValMap.get(key);
        if(currNode == head){
            return currNode.val;
        }
        else if(currNode == tail){
            currNode.prev.next = null;
            tail = currNode.prev;
            currNode.next = head;
            currNode.prev = null;
        }
        else{
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            currNode.next = head;
            currNode.prev = null;
        }
        head.prev = currNode;
        head = currNode;

        return currNode.val;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if(nodeValMap.containsKey(key)){
            nodeValMap.get(key).val = value;
            get(key);
            return;
        }
        if(nodeValMap.isEmpty()){
            head = newNode;
            tail = newNode;
            nodeValMap.put(key, newNode);
            return;
        }
        if(maxSize == 1 ){
            nodeValMap.remove(head.key);
            head = newNode;
            tail = newNode;
            nodeValMap.put(key, newNode);
            return;
        }
        
        nodeValMap.put(key, newNode);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        if(nodeValMap.size() > maxSize){
            nodeValMap.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
        }
        



    }
}
