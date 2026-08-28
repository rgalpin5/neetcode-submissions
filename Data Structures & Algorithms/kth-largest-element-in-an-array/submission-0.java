class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            maxHeap.offer(num);
        }
        int large = 0;
        for(int i = 0; i < k; i++) {
            large = maxHeap.poll();
        }
        return large;
    }
}
