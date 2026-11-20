class MedianFinder {
    int length;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.length = 0;
        this.minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(length == 0) {
            maxHeap.offer(num);
        }
        else if(length == 1) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        else if(length % 2 == 0) {
            if(num >= minHeap.peek()){ 
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }
            else {
                maxHeap.offer(num);
            }
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        length++;
    }
    
    public double findMedian() {
        if(length % 2 == 1) {
            return (double) maxHeap.peek();
        }
        else return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}
