class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int left;
        for(int i = 0;i<k;i++){
            maxHeap.add(new int[]{nums[i], i});
        }
        System.out.println(maxHeap.peek()[1]);

        for(int right = k-1;right<nums.length;right++){
            maxHeap.add(new int[]{nums[right], right});
            left = right-k+1;
            while(!(maxHeap.peek()[1] >= left && maxHeap.peek()[1] <= right) && !maxHeap.isEmpty()){
                maxHeap.poll();
            }
            
            ans[left] = maxHeap.peek()[0];
            
            
        }
        return ans;
    }
}
