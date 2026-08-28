class KthLargest {
    private PriorityQueue<Integer> maxHeap;
    private Stack<Integer> stack;
    private int k;
    public KthLargest(int k, int[] nums) {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    this.k = k;
    stack = new Stack<>();
    for(int num : nums) maxHeap.add(num);

    }
    
    public int add(int val) {
        maxHeap.add(val);
        for(int i = 1; i < k; i++) {
            stack.push(maxHeap.poll());
        }

        int kth = maxHeap.poll();
        maxHeap.add(kth);
        while(!stack.isEmpty()){ 
            maxHeap.add(stack.pop());
        }
        return kth;
    }
}
