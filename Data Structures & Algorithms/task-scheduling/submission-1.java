class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();
        for(char c : tasks) {
            freqs[c - 'A']++;
        }
        for(int freq : freqs) {
            if(freq != 0) maxHeap.offer(freq);
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                if(count > 0) {
                    queue.offer(new int[]{time + n, count});
                }
            }
            if(!queue.isEmpty()) {
                if(queue.peek()[0] <= time) {
                    maxHeap.offer(queue.poll()[1]);
                }
            }
        }

        return time;
    }
}
