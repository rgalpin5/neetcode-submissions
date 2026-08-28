class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this(val, null);
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}


class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode curr = head.next;
        int i = 0;
        while(i < index && curr != null) {
            curr = curr.next;
            i++;
        }
        if(curr == null) return -1;
        return curr.val;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        if (newHead.next == null) tail = newHead;
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        tail.next = newTail;
        tail = newTail;
    }

    public boolean remove(int index) {
        ListNode curr = head.next;
        ListNode prev = head;
        int i = 0;
        while(i < index && curr != null) {
            curr = curr.next;
            prev = prev.next;
            i++;
        }

        if(curr == null) return false;
        else {
            if(curr == tail) {
                tail = prev;
            }
            prev.next = curr.next;
            return true;
        }


    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head.next;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
