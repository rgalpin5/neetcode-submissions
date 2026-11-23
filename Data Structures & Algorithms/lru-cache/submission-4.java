class ListNode {
    ListNode prev;
    ListNode next;
    int value;
    int key;
    public ListNode(ListNode prev, ListNode next, int value, int key) {
        this.prev = prev;
        this.next = next;
        this.value = value;
        this.key = key;
    }
}

class LRUCache {
    ListNode head;
    ListNode tail;
    int currentCapacity;
    int maxCapacity;
    HashMap<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.head = new ListNode(null, null, -1, Integer.MIN_VALUE);
        this.tail = new ListNode(null, null, -1, Integer.MIN_VALUE);
        this.maxCapacity = capacity;
        this.currentCapacity = 0;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        boolean replaced = false;
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            replaced = true;
        }
        else if (currentCapacity == 0) {
            ListNode newNode = new ListNode(head, tail, value, key);
            head.next = newNode;
            tail.prev = newNode;
            map.put(key, newNode);
        }
        else {
            ListNode newNode = new ListNode(head, head.next, value, key);
            head.next = newNode;
            newNode.next.prev = newNode;
            map.put(key, newNode);
        }
        if(currentCapacity == maxCapacity && !replaced) {
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        else if (!replaced) currentCapacity++;
    }
}
