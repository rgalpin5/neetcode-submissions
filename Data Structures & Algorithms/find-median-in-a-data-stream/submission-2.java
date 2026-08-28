class MedianFinder {
    private PriorityQueue<Integer> rightHalf;
    private PriorityQueue<Integer> leftHalf;

    private int size;

    public MedianFinder() {
        rightHalf = new PriorityQueue<>();
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        size = 0;
    }
    
    public void addNum(int num) {
        leftHalf.offer(num);
        size++;
        if(size % 2 == 0){
            rightHalf.offer(leftHalf.poll());
        }
        if(size > 1 && leftHalf.peek() > rightHalf.peek()) {
            int temp = rightHalf.poll();
            rightHalf.offer(leftHalf.poll());
            leftHalf.offer(temp);
        }
    }
    
    public double findMedian() {
        if(size % 2 == 0){
            double ans = ((double) rightHalf.peek() + leftHalf.peek()) / 2.0;
            return ans;
        }
        else {
            return (double) leftHalf.peek();
        }
    }
}
