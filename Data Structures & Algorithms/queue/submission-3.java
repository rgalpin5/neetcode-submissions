class ListNode {
    public ListNode prev;
    public ListNode next;
    public int val;
    public ListNode(int value) {
        prev = null;
        next = null;
        val = value;
    }
}

class Deque {
    private ListNode start;
    private ListNode end;
    public Deque() {
        start = null;
        end = null;
        
    }

    public boolean isEmpty() {
        if (start == null)
            return true;
        else
            return false;
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        if(end == null) {
            start = newNode;
            end = newNode;
        }
        else {
            end.next = newNode;
            newNode.prev = end;
            end = newNode;
        }

    }

    public void appendleft(int value) {
        ListNode newNode = new ListNode(value);
        if(start == null) {
            start = newNode;
            end = newNode;
        }
        else {
            newNode.next = start;
            start.prev = newNode;
            start = newNode;
        }
    }

    public int pop() {
        if(start == null) return -1;
        int val = end.val;
        ListNode newEnd = end.prev;
        if(newEnd != null) {
            newEnd.next = null;
        } else {
            start = null;
        }

        end = newEnd;
        return val;
    }

    public int popleft() {
        if(start == null) return -1;
        ListNode newStart = start.next;
        if(newStart != null) {
            newStart.prev = null;
        } else {
            end = null;
        }
        int val = start.val;
        start = newStart;
        return val;
    }
}
