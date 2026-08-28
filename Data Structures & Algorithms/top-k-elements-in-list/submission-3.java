class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] ans = new int[k];

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((a -> a[1])));
        for(int num : freqMap.keySet()) {
            minHeap.offer(new int[]{num, freqMap.get(num)});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int i = 0;
        while(!minHeap.isEmpty()){
            ans[i] = minHeap.poll()[0];
            i++;
        }
        return ans;
    }
}
