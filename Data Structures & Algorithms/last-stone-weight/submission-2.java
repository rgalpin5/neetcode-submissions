class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length == 1) return stones[0];
        for(int stone : stones) maxHeap.offer(stone);
        int stone1 = 0;
        int stone2 = 0;

        while(maxHeap.size() > 1) {
            stone1 = maxHeap.poll();
            stone2 = maxHeap.poll();
            if(stone1 == stone2) {
                stone1 = 0;
                stone2 = 0;
            }
            else if(stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            }
            else if(stone2 > stone1) {
                maxHeap.offer(stone2 - stone1);
            }
            stone1 = 0;
            stone2 = 0;
        }

        if(maxHeap.isEmpty()) return 0;
        else return maxHeap.poll();
        
    }
}
